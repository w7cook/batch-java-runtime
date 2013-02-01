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

import java.sql.SQLException;
import java.util.Iterator;

import batch.sql.schema.ISchema;
import batch.sql.syntax.SQLQuery;
import batch.util.ForestReader;

public class JDBC<T> extends SQLBatch<T> {

	String url;

	public JDBC(ISchema schema, String url) throws SQLException {
		super(schema);
		this.url = url;
	}

	public JDBC(Class<T> rootClass, String url) throws SQLException {
		super(rootClass);
		this.url = url;
	}

	@Override
	public ForestReader createStream(SQLQuery rootQuery, ForestReader data) {
		return new JDBCForestReader(rootQuery, data, url);
	}

	@Override
	public Iterator<T> iterator() {
		throw new Error("Batch JDBC can only be used with the Jaba compiler");
	}

}
