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
package batch.sql.syntax;

import java.util.List;

import batch.sql.schema.IAlias;
import batch.sql.schema.IEntityType;
import batch.sql.schema.IMember;
import batch.sql.schema.ISchema;
import batch.util.Forest;

public abstract class Base implements SQLTranslation {

	int srcColumn;

	int srcLine;

	public String toString() {
		return run(new batch.syntax.Format());
	}

	public SQLTable getTableNoJoins(Env env) {
		throw new Error("NOT NEEDED???");
	}

	public SQLTranslation getTransformations(SQLTranslation base) {
		return base;
	}

	public SQLTable getBase(Env env) {
		throw new Error("NOT NEEDED???");
	}

	public SQLTranslation withoutTransformations() {
		return this;
	}

	public void toSQL(StringBuilder sb, List<Object> params, Forest data) {
		throw new Error("should never happen");
	}

	public SQLTranslation invertPath(SQLTranslation inverted, Env env,
			boolean fromChild) {
		throw new Error("BAD");
	}

	public SQLTranslation trimLast(Env env) {
		throw new Error("BAD");
	}

	@Override
	public SQLTranslation collectInsertArguments(String var, Call call) {
		return this;
	}

	public SQLTranslation dot(String field, ISchema schema, SQLQuery query,
			Env env, NormType normType) {
		SQLTable table = getTable();
		IEntityType source = table.getEntityType();
		IMember mem = source.get(field);
		if (mem instanceof IAlias) {
			Fun fun = ((IAlias) mem).getExpr();
			return fun.apply(this).normalize(schema, query, null, env, normType);
		}
		return new SQLField(table, mem);
	}
}
