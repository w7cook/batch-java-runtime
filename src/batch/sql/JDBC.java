/*******************************************************************************
 * The accompanying source code is made available to you under the terms of 
 * the UT Research License (this "UTRL"). By installing or using the code, 
 * you are consenting to be bound by the UTRL. See LICENSE.html for a 
 * full copy of the license.
 * 
 * Copyright � 2009, The University of Texas at Austin. All rights reserved.
 * 
 * UNIVERSITY EXPRESSLY DISCLAIMS ANY AND ALL WARRANTIES CONCERNING THIS 
 * SOFTWARE AND DOCUMENTATION, INCLUDING ANY WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR ANY PARTICULAR PURPOSE, NON-INFRINGEMENT AND WARRANTIES 
 * OF PERFORMANCE, AND ANY WARRANTY THAT MIGHT OTHERWISE ARISE FROM COURSE 
 * OF DEALING OR USAGE OF TRADE. NO WARRANTY IS EITHER EXPRESS OR IMPLIED 
 * WITH RESPECT TO THE USE OF THE SOFTWARE OR DOCUMENTATION. Under no circumstances 
 * shall University be liable for incidental, special, indirect, direct 
 * or consequential damages or loss of profits, interruption of business, 
 * or related expenses which may arise from use of Software or Documentation, 
 * including but not limited to those resulting from defects in Software 
 * and/or Documentation, or loss or inaccuracy of data of any kind.
 * 
 * Created by: William R. Cook and Eli Tilevich
 * with: Jose Falcon, Marc Fisher II, Ali Ibrahim, Yang Jiao, Ben Wiedermann
 * University of Texas at Austin and Virginia Tech
 ******************************************************************************/
package batch.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import batch.sql.schema.ISchema;
import batch.sql.syntax.Output;
import batch.sql.syntax.SQLQuery;
import batch.sql.syntax.SQLTranslation.SQLAction;
import batch.util.Forest;
import batch.util.ForestReader;
import batch.util.MultiForest;

public class JDBC<T> extends SQLBatch<T> {

	boolean usePrepared = true;
	Connection conn;
	Statement stmt;

	// "jdbc:mysql://localhost/test?user=monty&password=greatsqldb"
	public JDBC(ISchema schema, String url) throws SQLException {
		super(schema);
		conn = DriverManager.getConnection(url);
	}

	public JDBC(Class<T> rootClass, String url) throws SQLException {
		super(rootClass);
		conn = DriverManager.getConnection(url);
	}

	private void runQueries(SQLQuery q, ForestReader data, Forest results,
			String outerKey, MultiForest outerResults) throws SQLException {
		SQLAction action = q.getAction();
		switch (action) {
		case INSERT:
			if (q.insertResultName != null) {
				executeAndDecodeResults(q, data, results, outerKey, outerResults);
				return;
			} // fall through
		case UPDATE:
		case DELETE:
			executeUpdate(q, data, false);
		case NONE:
			for (SQLQuery sub : q.getSubqueries())
				runQueries(sub, data, results, q.getSubTag(), null);
			break;
		case SELECT:
			executeAndDecodeResults(q, data, results, outerKey, outerResults);
		}
	}

	private void executeAndDecodeResults(SQLQuery q, ForestReader data, Forest results,
			String outerKey, MultiForest outerResults) throws SQLException {
		ResultSet qr = null;
		try {
			boolean singleRow = q.isSingleRow();
			// set up outer result iterator
      Iterator<Forest> iter = null;
      Forest outer = null;
			MultiForest myResults = null;
			if (!singleRow) {
				if (outerResults != null) {
				  iter = outerResults.forestIterator();
					if (!iter.hasNext())
						return;
					outer = iter.next();
					myResults = outer.newForestIteration(q.getVar());
				} else
					myResults = results.newForestIteration(q.getVar());
			}
			// execute the query, prepared or not
			if (q.getAction() == SQLAction.INSERT)
				qr = executeUpdate(q, data, true);
			else
				qr = executeQuery(q, data);
			// decode the results
			while (qr.next()) {
				// find the outer row that matches this row
				if (iter != null)
					while (iter.hasNext()
							&& !outer.get(outerKey).equals(qr.getObject("parent"))) {
						outer = iter.next();
						myResults = outer.newForestIteration(q.getVar());
					}
				// decode the columns
				Forest row = singleRow ? results : myResults.newIteration();
				if (q.getAction() == SQLAction.INSERT)
					row.put(q.insertResultName, qr.getObject(1));
				else
					for (Output x : q.getProjections()) {
						String name = x.getLocation();
						row.put(name, qr.getObject(name));
					}
			}
			// fill in any remaining parent results with null
			if (iter != null)
				while (iter.hasNext())
					iter.next().newTable(q.getVar());
			if (singleRow)
				for (SQLQuery sub : q.getSubqueries())
					runQueries(sub, data, results, q.getSubTag(), null);
			else
				for (SQLQuery sub : q.getSubqueries())
					runQueries(sub, data, null, q.getSubTag(), myResults);
		} finally {
			if (qr != null) {
				qr.close();
			}
		}
	}

	private ResultSet executeQuery(SQLQuery q, ForestReader data) throws SQLException {
		ResultSet qr;
		if (!usePrepared) {
			String sql = getSQL(q, null, data);
			qr = stmt.executeQuery(sql);
		} else {
			List<Object> params = new ArrayList<Object>();
			String sql = getSQL(q, params, data);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int i = 1;
			for (Object param : params)
				pstmt.setObject(i++, param);
			qr = pstmt.executeQuery();
		}
		return qr;
	}

	private ResultSet executeUpdate(SQLQuery q, ForestReader data, boolean returnKeys)
			throws SQLException {
		int num;
		ResultSet result = null;
		int autoGeneratedKeys = returnKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS;
		if (!usePrepared) {
			String sql = getSQL(q, null, data);
			num = stmt.executeUpdate(sql, autoGeneratedKeys);
			if (returnKeys) 
				result = stmt.getGeneratedKeys();
		} else {
			List<Object> params = new ArrayList<Object>();
			String sql = getSQL(q, params, data);
			PreparedStatement pstmt = conn.prepareStatement(sql, autoGeneratedKeys);
			int i = 1;
			for (Object param : params)
				pstmt.setObject(i++, param);
			num = pstmt.executeUpdate();
			if (returnKeys) 
				result = pstmt.getGeneratedKeys();
		}
		System.out.println("Affected " + num + " rows");
		return result;
	}

	@Override
	public void invokeDatabase(SQLQuery rootQuery, ForestReader data, Forest results) {
		try {
			if (!usePrepared)
				stmt = conn.createStatement();
			runQueries(rootQuery, data, results, null, null);
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			throw new Error("databse exception", ex);
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore
				stmt = null;
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		throw new Error("Batch JDBC can only be used with the Jaba compiler");
	}

}
