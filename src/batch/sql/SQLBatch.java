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

import java.util.Iterator;
import java.util.List;

import batch.Service;
import batch.sql.schema.ISchema;
import batch.sql.schema.javareflect.Schema;
import batch.sql.syntax.Env;
import batch.sql.syntax.Prim;
import batch.sql.syntax.SQLQuery;
import batch.sql.syntax.SQLTranslation;
import batch.util.Forest;
import batch.util.ForestReader;
import batch.util.ForestWriter;

public class SQLBatch<T> extends batch.sql.syntax.Factory implements Service<SQLTranslation, T> {

	SQLQuery rootQuery;
	ISchema schema;
	
	public SQLBatch(ISchema schema) {
		super();
		this.schema = schema;
	}

	public SQLBatch(Class<T> rootClass) {
		super();
		this.schema = new Schema(rootClass);
	}

	public ForestReader execute(SQLTranslation exp, ForestReader in) {
		System.err.println(exp.toString());
		return createStream(setupQueries(exp), in);
	}

	public void executeServer(SQLTranslation exp, ForestReader in, ForestWriter out) {
		execute(exp, in)
			.copyTo(out);
		System.out.println( out.toString() );
	}

	private SQLQuery setupQueries(SQLTranslation exp) {
		rootQuery = new SQLQuery(true);
		Env env = new Env(rootQuery);
		doQueries(exp, env);
		return rootQuery;
	}

	private void doQueries(SQLTranslation exp, Env env) {
		if (exp instanceof Prim)
			for (SQLTranslation e : ((Prim) exp).getArgs())
				doQueries(e, env);
		else {
			System.err.println("SCRIPT: " + exp.toString());
			exp.normalize(schema, rootQuery, null, env, SQLTranslation.NormType.NORMAL);
		}
	}

	protected static String getSQL(SQLQuery q, List<Object> params, ForestReader data) {
		StringBuilder sb = new StringBuilder();
		q.toSQL(sb, params, data);
		String sql = sb.toString();
		System.err.println(sql);
		return sql;
	}

	protected ForestReader createStream(SQLQuery q, ForestReader data) {
		getSQL(q, null, data);
		for (SQLQuery sub : q.getSubqueries())
			createStream(sub, data);
		return new Forest();
	}

	public Iterator<T> iterator() {
		throw new Error("Must run SQL batches using Jaba compiler");
	}

}
