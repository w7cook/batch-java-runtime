package batch.syntax;

import java.util.List;

import batch.Op;
import batch.util.BatchFactoryHelper;

public class Format extends BatchFactoryHelper<String> {

	@Override
	public String Var(String name) {
		return name;
	}

	@Override
	public String Data(Object value) {
		if (value == null) {
			return "null";
		} else if (value instanceof String) {
			String str = (String) value;
			str = str.replace("\\", "\\\\");
			str = str.replace("\"", "\\\"");
			return "\"" + str + "\"";
		} else if (value instanceof java.sql.Date
				|| value instanceof java.util.Date) {
			return "date(\"" + value.toString() + "\")";
		} else
			return value.toString();
	}

	@Override
	public String Fun(String var, String body) {
		return "fun(" + var + ")" + body;
	}

	@Override
	public String Prim(Op op, List<String> args) {
		if (args.size() == 0) {
			return "skip";
		} else if (args.size() == 1 && !op.unary()) {
				return args.get(0);
		} else {
			String x = null;
			int n = 0;
			for (int i = 0; i < args.size(); i++) {
				String s = args.get(i);
				if (s == null) 
					continue;
				n++;
				if (n == 1)
					x = s;
				else {
					x += ' ';
					x += op.getOpSymbol();
					x += ' ';
					x += s;
				}
			}
			if (n == 1 && op.unary())
				x = "(" + op.getOpSymbol() + x + ")";
			else if (n > 1)
				x = "(" + x + ")";
			return x;
		}
	}

	@Override
	public String Prop(String base, String field) {
		return base + "." + field;
	}

	@Override
	public String Assign(Op op, String target, String source) {
		if (op == Op.SEQ)
			return target + "=" + source;
		else
			return target + op.getOpSymbol() + "=" + source;
	}

	@Override
	public String Let(String var, String expression, String body) {
		return "var " + var + "=" + expression + "; " + body;
	}

	@Override
	public String If(String condition, String thenExp,
			String elseExp) {
		if (elseExp.equals("skip"))
			return "if " + condition + " then " + thenExp + " end";
		else
			return "if " + condition + " then " + thenExp + " else " + elseExp + " end";
	}

	@Override
	public String Loop(String var, String collection, String body) {
		return "for " + var + " in " + collection + " do "
				+ body + " end";
	}

	@Override
	public String Call(String target, String method,
			List<String> args) {
		String x = target + '.' + method + '(';
		int i = 0;
		for (String e : args) {
			if (i++ > 0)
				x += ", ";
			x += e;
		}
		return x + ")";
	}

	@Override
	public String In(String location) {
		return "@" + location;
	}

	@Override
	public String Out(String location, String expression) {
		return location + ':' + expression;
	}

}
