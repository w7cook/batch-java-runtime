
grammar BatchScript;

tokens {
	IF = 'if';
	THEN = 'then';
	ELSE = 'else';
	FOR = 'for';
	FUNCTION = 'function';
	OUTPUT = 'OUTPUT';
	VAR = 'var';
	TRUE = 'true';
	FALSE = 'false';	
	IN = 'in';
	DATE = 'date';	
}

@header {
package batch.syntax;
}
@lexer::header {
package batch.syntax;
}

@members {
    	Factory f = new batch.syntax.Factory();
    	
    	static public Expression parse(String script) throws org.antlr.runtime.RecognitionException {
    		org.antlr.runtime.CharStream stream = new org.antlr.runtime.ANTLRStringStream(
    			script);
    		BatchScriptLexer lexer = new BatchScriptLexer(stream);
    		BatchScriptParser parser = new BatchScriptParser(new CommonTokenStream(
    			lexer));
    		return parser.statements();
    	}

}

main returns [Expression value]
	: e=statements { value = e; } EOF
	;

statements returns [Expression value]
	: e=statement {value = e;} (';' (es=statements { value = f.Prim(batch.Op.SEQ, value, es); })?)?
	| VAR x=ID '=' e=expr ';' b=statements    { value = f.Let(x.getText(), e, b); }
 	;

block returns [Expression value]
    : '{' e=statements '}'  {value = e;} 
    ;

statement returns [Expression value]
	: FOR '(' x=ID IN e=expr ')' b=block  { value = f.Loop(x.getText(), e, b); }
	| e=expr { value = e; }
	;

expr returns [Expression value]
	: FUNCTION '(' x=ID ')' e=block	    { value = f.Fun(x.getText(), e); }
	| e=or { value = e; }
	;	 

or returns [Expression value]
	: a=and {value=a;} ('||' b=or {value=f.Prim(batch.Op.OR, a, b);})?
	;
and returns [Expression value]
	: a=comp {value=a;} ('&&' b=and {value=f.Prim(batch.Op.AND, a, b);})?
	;  

comp returns [Expression value]
	: a=term {value=a;} (op=compop b=comp {value=f.Prim(op, a, b);})?
	;
compop returns [batch.Op op]
 	: '==' { op = batch.Op.EQ; }
 	| '!=' { op = batch.Op.NE; }
 	| '<='  { op = batch.Op.LE; }
 	| '<'  { op = batch.Op.LT; }
 	| '>'  { op = batch.Op.GT; }
 	| '>='  { op = batch.Op.GE; }
	;

term returns [Expression value]
	: a=factor {value=a;} (op=addop b=term {value=f.Prim(op, a, b);})?
	;  
addop returns [batch.Op op]
 	: '+' { op = batch.Op.ADD; }
 	| '-'  { op = batch.Op.SUB; }
	;

factor returns [Expression value]
	: a=base {value=a;} (op=mulop b=factor {value=f.Prim(op, a, b);})?
	;
mulop returns [batch.Op op]
 	: '*' { op = batch.Op.MUL; }
 	| '/'  { op = batch.Op.DIV; }
 	;

not returns [Expression value]
	: '!' e=not {value=f.Prim(batch.Op.NOT, e); }
	| e=comp {value=e;}
	;


base returns [Expression value]
   :  a=prim {value=a;} ('=' b=expr { value=f.Assign(a, b); })?
	| IF a=expr THEN t=block (ELSE e=block)?  { value = f.If(a, t, e); }
	| x=INT { value = f.Data(Integer.parseInt(x.getText())); }
	| x=STRING { 
		String str = x.getText();
		str = str.substring(1, str.length() - 1);
		str = str.replace("\\\"", "\"");
		str = str.replace("\\\\", "\\");
		value = f.Data(str); }
	| DATE '(' x=STRING ')' { 
		String str = x.getText();
		str = str.substring(1, str.length() - 1);
		value = f.Data(java.sql.Date.valueOf(str)); 
		}
	| x=FLOAT { value = f.Data(Float.parseFloat(x.getText())); }
	| x=TRUE { value = f.Data(true); }
	| x=FALSE{ value = f.Data(false); }
	| '(' e=expr ')' { value = e; }
	;

prim  returns [Expression value]
  : OUTPUT '(' b=STRING ',' e=expr ')' { 
  		String str = b.getText();
		str = str.substring(1, str.length() - 1);
		value = f.Out(str, e); 
	}
  | b=ID { value = f.Var(b.getText()); } r=access[value] { value = r; }
  ;

// Prop and Call
access[Expression base] returns [Expression value]
	: '.' x=ID  {value = f.Prop(base, x.getText()); }
	    ( '(' { List<Expression> args = new ArrayList(); }
			( e=expr { args.add(e); }
			  (',' e=expr {args.add(e); })*
			)? 
		   ')' {value = f.Call(base, x.getText(), args); }
	    )?
	    r=access[value] { value = r; }
 	| {value = base; }
	;


fragment DIGIT : '0'..'9';
fragment ALPHA : ('a'..'z') | ('A'..'Z') | '_';

ID  :	ALPHA (ALPHA|DIGIT)*
    ;

INT :	'-'? DIGIT+
    ;

FLOAT
    :   '-'? DIGIT+ '.' DIGIT* EXPONENT?
    |   '-'? '.' DIGIT+ EXPONENT?
    |   '-'? DIGIT+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
	| '\t'
	| '\r'
	| '\n'
	) {$channel=HIDDEN;}
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? DIGIT+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..
'F') ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

STRING
    :  '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | UNICODE_ESC | ~('\\'|'"') )* '"' // should have 
    ;

