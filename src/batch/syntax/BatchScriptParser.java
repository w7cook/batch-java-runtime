// $ANTLR 3.4 /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g 2012-07-28 14:40:00

package batch.syntax;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class BatchScriptParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALPHA", "COMMENT", "DATE", "DIGIT", "ELSE", "EXPONENT", "FALSE", "FLOAT", "FOR", "FUNCTION", "HEX_DIGIT", "ID", "IF", "IN", "INT", "OUTPUT", "STRING", "THEN", "TRUE", "UNICODE_ESC", "VAR", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int ALPHA=4;
    public static final int COMMENT=5;
    public static final int DATE=6;
    public static final int DIGIT=7;
    public static final int ELSE=8;
    public static final int EXPONENT=9;
    public static final int FALSE=10;
    public static final int FLOAT=11;
    public static final int FOR=12;
    public static final int FUNCTION=13;
    public static final int HEX_DIGIT=14;
    public static final int ID=15;
    public static final int IF=16;
    public static final int IN=17;
    public static final int INT=18;
    public static final int OUTPUT=19;
    public static final int STRING=20;
    public static final int THEN=21;
    public static final int TRUE=22;
    public static final int UNICODE_ESC=23;
    public static final int VAR=24;
    public static final int WS=25;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public BatchScriptParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public BatchScriptParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return BatchScriptParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g"; }


        	Factory f = new batch.syntax.Factory();
        	
        	static public Expression parse(String script) throws org.antlr.runtime.RecognitionException {
        		org.antlr.runtime.CharStream stream = new org.antlr.runtime.ANTLRStringStream(
        			script);
        		BatchScriptLexer lexer = new BatchScriptLexer(stream);
        		BatchScriptParser parser = new BatchScriptParser(new CommonTokenStream(
        			lexer));
        		return parser.statements();
        	}




    // $ANTLR start "main"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:39:1: main returns [Expression value] : e= statements EOF ;
    public final Expression main() throws RecognitionException {
        Expression value = null;


        Expression e =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:40:2: (e= statements EOF )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:40:4: e= statements EOF
            {
            pushFollow(FOLLOW_statements_in_main133);
            e=statements();

            state._fsp--;


             value = e; 

            match(input,EOF,FOLLOW_EOF_in_main137); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "main"



    // $ANTLR start "statements"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:43:1: statements returns [Expression value] : (e= statement ( ';' (es= statements )? )? | VAR x= ID '=' e= expr ';' b= statements );
    public final Expression statements() throws RecognitionException {
        Expression value = null;


        Token x=null;
        Expression e =null;

        Expression es =null;

        Expression b =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:44:2: (e= statement ( ';' (es= statements )? )? | VAR x= ID '=' e= expr ';' b= statements )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DATE||(LA3_0 >= FALSE && LA3_0 <= FUNCTION)||(LA3_0 >= ID && LA3_0 <= IF)||(LA3_0 >= INT && LA3_0 <= STRING)||LA3_0==TRUE||LA3_0==29) ) {
                alt3=1;
            }
            else if ( (LA3_0==VAR) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:44:4: e= statement ( ';' (es= statements )? )?
                    {
                    pushFollow(FOLLOW_statement_in_statements154);
                    e=statement();

                    state._fsp--;


                    value = e;

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:44:29: ( ';' (es= statements )? )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==37) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:44:30: ';' (es= statements )?
                            {
                            match(input,37,FOLLOW_37_in_statements159); 

                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:44:34: (es= statements )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==DATE||(LA1_0 >= FALSE && LA1_0 <= FUNCTION)||(LA1_0 >= ID && LA1_0 <= IF)||(LA1_0 >= INT && LA1_0 <= STRING)||LA1_0==TRUE||LA1_0==VAR||LA1_0==29) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:44:35: es= statements
                                    {
                                    pushFollow(FOLLOW_statements_in_statements164);
                                    es=statements();

                                    state._fsp--;


                                     value = f.Prim(batch.Op.SEQ, value, es); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:45:4: VAR x= ID '=' e= expr ';' b= statements
                    {
                    match(input,VAR,FOLLOW_VAR_in_statements175); 

                    x=(Token)match(input,ID,FOLLOW_ID_in_statements179); 

                    match(input,40,FOLLOW_40_in_statements181); 

                    pushFollow(FOLLOW_expr_in_statements185);
                    e=expr();

                    state._fsp--;


                    match(input,37,FOLLOW_37_in_statements187); 

                    pushFollow(FOLLOW_statements_in_statements191);
                    b=statements();

                    state._fsp--;


                     value = f.Let(x.getText(), e, b); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "statements"



    // $ANTLR start "block"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:48:1: block returns [Expression value] : '{' e= statements '}' ;
    public final Expression block() throws RecognitionException {
        Expression value = null;


        Expression e =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:49:5: ( '{' e= statements '}' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:49:7: '{' e= statements '}'
            {
            match(input,44,FOLLOW_44_in_block215); 

            pushFollow(FOLLOW_statements_in_block219);
            e=statements();

            state._fsp--;


            match(input,46,FOLLOW_46_in_block221); 

            value = e;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "block"



    // $ANTLR start "statement"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:52:1: statement returns [Expression value] : ( FOR '(' x= ID IN e= expr ')' b= block |e= expr );
    public final Expression statement() throws RecognitionException {
        Expression value = null;


        Token x=null;
        Expression e =null;

        Expression b =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:53:2: ( FOR '(' x= ID IN e= expr ')' b= block |e= expr )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==FOR) ) {
                alt4=1;
            }
            else if ( (LA4_0==DATE||(LA4_0 >= FALSE && LA4_0 <= FLOAT)||LA4_0==FUNCTION||(LA4_0 >= ID && LA4_0 <= IF)||(LA4_0 >= INT && LA4_0 <= STRING)||LA4_0==TRUE||LA4_0==29) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:53:4: FOR '(' x= ID IN e= expr ')' b= block
                    {
                    match(input,FOR,FOLLOW_FOR_in_statement243); 

                    match(input,29,FOLLOW_29_in_statement245); 

                    x=(Token)match(input,ID,FOLLOW_ID_in_statement249); 

                    match(input,IN,FOLLOW_IN_in_statement251); 

                    pushFollow(FOLLOW_expr_in_statement255);
                    e=expr();

                    state._fsp--;


                    match(input,30,FOLLOW_30_in_statement257); 

                    pushFollow(FOLLOW_block_in_statement261);
                    b=block();

                    state._fsp--;


                     value = f.Loop(x.getText(), e, b); 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:54:4: e= expr
                    {
                    pushFollow(FOLLOW_expr_in_statement271);
                    e=expr();

                    state._fsp--;


                     value = e; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "statement"



    // $ANTLR start "expr"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:57:1: expr returns [Expression value] : ( FUNCTION '(' x= ID ')' e= block |e= or );
    public final Expression expr() throws RecognitionException {
        Expression value = null;


        Token x=null;
        Expression e =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:58:2: ( FUNCTION '(' x= ID ')' e= block |e= or )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==FUNCTION) ) {
                alt5=1;
            }
            else if ( (LA5_0==DATE||(LA5_0 >= FALSE && LA5_0 <= FLOAT)||(LA5_0 >= ID && LA5_0 <= IF)||(LA5_0 >= INT && LA5_0 <= STRING)||LA5_0==TRUE||LA5_0==29) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:58:4: FUNCTION '(' x= ID ')' e= block
                    {
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expr288); 

                    match(input,29,FOLLOW_29_in_expr290); 

                    x=(Token)match(input,ID,FOLLOW_ID_in_expr294); 

                    match(input,30,FOLLOW_30_in_expr296); 

                    pushFollow(FOLLOW_block_in_expr300);
                    e=block();

                    state._fsp--;


                     value = f.Fun(x.getText(), e); 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:59:4: e= or
                    {
                    pushFollow(FOLLOW_or_in_expr313);
                    e=or();

                    state._fsp--;


                     value = e; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "expr"



    // $ANTLR start "or"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:62:1: or returns [Expression value] : a= and ( '||' b= or )? ;
    public final Expression or() throws RecognitionException {
        Expression value = null;


        Expression a =null;

        Expression b =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:63:2: (a= and ( '||' b= or )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:63:4: a= and ( '||' b= or )?
            {
            pushFollow(FOLLOW_and_in_or334);
            a=and();

            state._fsp--;


            value=a;

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:63:21: ( '||' b= or )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==45) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:63:22: '||' b= or
                    {
                    match(input,45,FOLLOW_45_in_or339); 

                    pushFollow(FOLLOW_or_in_or343);
                    b=or();

                    state._fsp--;


                    value=f.Prim(batch.Op.OR, a, b);

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "or"



    // $ANTLR start "and"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:65:1: and returns [Expression value] : a= comp ( '&&' b= and )? ;
    public final Expression and() throws RecognitionException {
        Expression value = null;


        Expression a =null;

        Expression b =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:66:2: (a= comp ( '&&' b= and )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:66:4: a= comp ( '&&' b= and )?
            {
            pushFollow(FOLLOW_comp_in_and363);
            a=comp();

            state._fsp--;


            value=a;

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:66:22: ( '&&' b= and )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:66:23: '&&' b= and
                    {
                    match(input,28,FOLLOW_28_in_and368); 

                    pushFollow(FOLLOW_and_in_and372);
                    b=and();

                    state._fsp--;


                    value=f.Prim(batch.Op.AND, a, b);

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "and"



    // $ANTLR start "comp"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:69:1: comp returns [Expression value] : a= term (op= compop b= comp )? ;
    public final Expression comp() throws RecognitionException {
        Expression value = null;


        Expression a =null;

        batch.Op op =null;

        Expression b =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:70:2: (a= term (op= compop b= comp )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:70:4: a= term (op= compop b= comp )?
            {
            pushFollow(FOLLOW_term_in_comp395);
            a=term();

            state._fsp--;


            value=a;

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:70:22: (op= compop b= comp )?
            int alt8=2;
            switch ( input.LA(1) ) {
                case 41:
                    {
                    alt8=1;
                    }
                    break;
                case 27:
                    {
                    alt8=1;
                    }
                    break;
                case 39:
                    {
                    alt8=1;
                    }
                    break;
                case 38:
                    {
                    alt8=1;
                    }
                    break;
                case 42:
                    {
                    alt8=1;
                    }
                    break;
                case 43:
                    {
                    alt8=1;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:70:23: op= compop b= comp
                    {
                    pushFollow(FOLLOW_compop_in_comp402);
                    op=compop();

                    state._fsp--;


                    pushFollow(FOLLOW_comp_in_comp406);
                    b=comp();

                    state._fsp--;


                    value=f.Prim(op, a, b);

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "comp"



    // $ANTLR start "compop"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:72:1: compop returns [batch.Op op] : ( '==' | '!=' | '<=' | '<' | '>' | '>=' );
    public final batch.Op compop() throws RecognitionException {
        batch.Op op = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:73:3: ( '==' | '!=' | '<=' | '<' | '>' | '>=' )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt9=1;
                }
                break;
            case 27:
                {
                alt9=2;
                }
                break;
            case 39:
                {
                alt9=3;
                }
                break;
            case 38:
                {
                alt9=4;
                }
                break;
            case 42:
                {
                alt9=5;
                }
                break;
            case 43:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:73:5: '=='
                    {
                    match(input,41,FOLLOW_41_in_compop425); 

                     op = batch.Op.EQ; 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:74:5: '!='
                    {
                    match(input,27,FOLLOW_27_in_compop433); 

                     op = batch.Op.NE; 

                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:75:5: '<='
                    {
                    match(input,39,FOLLOW_39_in_compop441); 

                     op = batch.Op.LE; 

                    }
                    break;
                case 4 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:76:5: '<'
                    {
                    match(input,38,FOLLOW_38_in_compop450); 

                     op = batch.Op.LT; 

                    }
                    break;
                case 5 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:77:5: '>'
                    {
                    match(input,42,FOLLOW_42_in_compop459); 

                     op = batch.Op.GT; 

                    }
                    break;
                case 6 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:78:5: '>='
                    {
                    match(input,43,FOLLOW_43_in_compop468); 

                     op = batch.Op.GE; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return op;
    }
    // $ANTLR end "compop"



    // $ANTLR start "term"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:81:1: term returns [Expression value] : a= factor (op= addop b= term )? ;
    public final Expression term() throws RecognitionException {
        Expression value = null;


        Expression a =null;

        batch.Op op =null;

        Expression b =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:82:2: (a= factor (op= addop b= term )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:82:4: a= factor (op= addop b= term )?
            {
            pushFollow(FOLLOW_factor_in_term488);
            a=factor();

            state._fsp--;


            value=a;

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:82:24: (op= addop b= term )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==32) ) {
                alt10=1;
            }
            else if ( (LA10_0==34) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:82:25: op= addop b= term
                    {
                    pushFollow(FOLLOW_addop_in_term495);
                    op=addop();

                    state._fsp--;


                    pushFollow(FOLLOW_term_in_term499);
                    b=term();

                    state._fsp--;


                    value=f.Prim(op, a, b);

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "term"



    // $ANTLR start "addop"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:84:1: addop returns [batch.Op op] : ( '+' | '-' );
    public final batch.Op addop() throws RecognitionException {
        batch.Op op = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:85:3: ( '+' | '-' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==32) ) {
                alt11=1;
            }
            else if ( (LA11_0==34) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:85:5: '+'
                    {
                    match(input,32,FOLLOW_32_in_addop520); 

                     op = batch.Op.ADD; 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:86:5: '-'
                    {
                    match(input,34,FOLLOW_34_in_addop528); 

                     op = batch.Op.SUB; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return op;
    }
    // $ANTLR end "addop"



    // $ANTLR start "factor"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:89:1: factor returns [Expression value] : a= base (op= mulop b= factor )? ;
    public final Expression factor() throws RecognitionException {
        Expression value = null;


        Expression a =null;

        batch.Op op =null;

        Expression b =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:90:2: (a= base (op= mulop b= factor )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:90:4: a= base (op= mulop b= factor )?
            {
            pushFollow(FOLLOW_base_in_factor548);
            a=base();

            state._fsp--;


            value=a;

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:90:22: (op= mulop b= factor )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==31) ) {
                alt12=1;
            }
            else if ( (LA12_0==36) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:90:23: op= mulop b= factor
                    {
                    pushFollow(FOLLOW_mulop_in_factor555);
                    op=mulop();

                    state._fsp--;


                    pushFollow(FOLLOW_factor_in_factor559);
                    b=factor();

                    state._fsp--;


                    value=f.Prim(op, a, b);

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "factor"



    // $ANTLR start "mulop"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:92:1: mulop returns [batch.Op op] : ( '*' | '/' );
    public final batch.Op mulop() throws RecognitionException {
        batch.Op op = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:93:3: ( '*' | '/' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            else if ( (LA13_0==36) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:93:5: '*'
                    {
                    match(input,31,FOLLOW_31_in_mulop578); 

                     op = batch.Op.MUL; 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:94:5: '/'
                    {
                    match(input,36,FOLLOW_36_in_mulop586); 

                     op = batch.Op.DIV; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return op;
    }
    // $ANTLR end "mulop"



    // $ANTLR start "not"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:97:1: not returns [Expression value] : ( '!' e= not |e= comp );
    public final Expression not() throws RecognitionException {
        Expression value = null;


        Expression e =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:98:2: ( '!' e= not |e= comp )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            else if ( (LA14_0==DATE||(LA14_0 >= FALSE && LA14_0 <= FLOAT)||(LA14_0 >= ID && LA14_0 <= IF)||(LA14_0 >= INT && LA14_0 <= STRING)||LA14_0==TRUE||LA14_0==29) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:98:4: '!' e= not
                    {
                    match(input,26,FOLLOW_26_in_not605); 

                    pushFollow(FOLLOW_not_in_not609);
                    e=not();

                    state._fsp--;


                    value=f.Prim(batch.Op.NOT, e); 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:99:4: e= comp
                    {
                    pushFollow(FOLLOW_comp_in_not618);
                    e=comp();

                    state._fsp--;


                    value=e;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "not"



    // $ANTLR start "base"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:103:1: base returns [Expression value] : (a= prim ( '=' b= expr )? | IF a= expr THEN t= block ( ELSE e= block )? |x= INT |x= STRING | DATE '(' x= STRING ')' |x= FLOAT |x= TRUE |x= FALSE | '(' e= expr ')' );
    public final Expression base() throws RecognitionException {
        Expression value = null;


        Token x=null;
        Expression a =null;

        Expression b =null;

        Expression t =null;

        Expression e =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:104:4: (a= prim ( '=' b= expr )? | IF a= expr THEN t= block ( ELSE e= block )? |x= INT |x= STRING | DATE '(' x= STRING ')' |x= FLOAT |x= TRUE |x= FALSE | '(' e= expr ')' )
            int alt17=9;
            switch ( input.LA(1) ) {
            case ID:
            case OUTPUT:
                {
                alt17=1;
                }
                break;
            case IF:
                {
                alt17=2;
                }
                break;
            case INT:
                {
                alt17=3;
                }
                break;
            case STRING:
                {
                alt17=4;
                }
                break;
            case DATE:
                {
                alt17=5;
                }
                break;
            case FLOAT:
                {
                alt17=6;
                }
                break;
            case TRUE:
                {
                alt17=7;
                }
                break;
            case FALSE:
                {
                alt17=8;
                }
                break;
            case 29:
                {
                alt17=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:104:7: a= prim ( '=' b= expr )?
                    {
                    pushFollow(FOLLOW_prim_in_base641);
                    a=prim();

                    state._fsp--;


                    value=a;

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:104:25: ( '=' b= expr )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==40) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:104:26: '=' b= expr
                            {
                            match(input,40,FOLLOW_40_in_base646); 

                            pushFollow(FOLLOW_expr_in_base650);
                            b=expr();

                            state._fsp--;


                             value=f.Assign(a, b); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:105:4: IF a= expr THEN t= block ( ELSE e= block )?
                    {
                    match(input,IF,FOLLOW_IF_in_base659); 

                    pushFollow(FOLLOW_expr_in_base663);
                    a=expr();

                    state._fsp--;


                    match(input,THEN,FOLLOW_THEN_in_base665); 

                    pushFollow(FOLLOW_block_in_base669);
                    t=block();

                    state._fsp--;


                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:105:27: ( ELSE e= block )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==ELSE) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:105:28: ELSE e= block
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_base672); 

                            pushFollow(FOLLOW_block_in_base676);
                            e=block();

                            state._fsp--;


                            }
                            break;

                    }


                     value = f.If(a, t, e); 

                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:106:4: x= INT
                    {
                    x=(Token)match(input,INT,FOLLOW_INT_in_base688); 

                     value = f.Data(Integer.parseInt(x.getText())); 

                    }
                    break;
                case 4 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:107:4: x= STRING
                    {
                    x=(Token)match(input,STRING,FOLLOW_STRING_in_base697); 

                     
                    		String str = x.getText();
                    		str = str.substring(1, str.length() - 1);
                    		str = str.replace("\\\"", "\"");
                    		str = str.replace("\\\\", "\\");
                    		value = f.Data(str); 

                    }
                    break;
                case 5 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:113:4: DATE '(' x= STRING ')'
                    {
                    match(input,DATE,FOLLOW_DATE_in_base704); 

                    match(input,29,FOLLOW_29_in_base706); 

                    x=(Token)match(input,STRING,FOLLOW_STRING_in_base710); 

                    match(input,30,FOLLOW_30_in_base712); 

                     
                    		String str = x.getText();
                    		str = str.substring(1, str.length() - 1);
                    		value = f.Data(java.sql.Date.valueOf(str)); 
                    		

                    }
                    break;
                case 6 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:118:4: x= FLOAT
                    {
                    x=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_base721); 

                     value = f.Data(Float.parseFloat(x.getText())); 

                    }
                    break;
                case 7 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:119:4: x= TRUE
                    {
                    x=(Token)match(input,TRUE,FOLLOW_TRUE_in_base730); 

                     value = f.Data(true); 

                    }
                    break;
                case 8 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:120:4: x= FALSE
                    {
                    x=(Token)match(input,FALSE,FOLLOW_FALSE_in_base739); 

                     value = f.Data(false); 

                    }
                    break;
                case 9 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:121:4: '(' e= expr ')'
                    {
                    match(input,29,FOLLOW_29_in_base745); 

                    pushFollow(FOLLOW_expr_in_base749);
                    e=expr();

                    state._fsp--;


                    match(input,30,FOLLOW_30_in_base751); 

                     value = e; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "base"



    // $ANTLR start "prim"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:124:1: prim returns [Expression value] : ( OUTPUT '(' b= STRING ',' e= expr ')' |b= ID r= access[value] );
    public final Expression prim() throws RecognitionException {
        Expression value = null;


        Token b=null;
        Expression e =null;

        Expression r =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:125:3: ( OUTPUT '(' b= STRING ',' e= expr ')' |b= ID r= access[value] )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==OUTPUT) ) {
                alt18=1;
            }
            else if ( (LA18_0==ID) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:125:5: OUTPUT '(' b= STRING ',' e= expr ')'
                    {
                    match(input,OUTPUT,FOLLOW_OUTPUT_in_prim770); 

                    match(input,29,FOLLOW_29_in_prim772); 

                    b=(Token)match(input,STRING,FOLLOW_STRING_in_prim776); 

                    match(input,33,FOLLOW_33_in_prim778); 

                    pushFollow(FOLLOW_expr_in_prim782);
                    e=expr();

                    state._fsp--;


                    match(input,30,FOLLOW_30_in_prim784); 

                     
                      		String str = b.getText();
                    		str = str.substring(1, str.length() - 1);
                    		value = f.Out(str, e); 
                    	

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:130:5: b= ID r= access[value]
                    {
                    b=(Token)match(input,ID,FOLLOW_ID_in_prim794); 

                     value = f.Var(b.getText()); 

                    pushFollow(FOLLOW_access_in_prim800);
                    r=access(value);

                    state._fsp--;


                     value = r; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "prim"



    // $ANTLR start "access"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:134:1: access[Expression base] returns [Expression value] : ( '.' x= ID ( '(' (e= expr ( ',' e= expr )* )? ')' )? r= access[value] |);
    public final Expression access(Expression base) throws RecognitionException {
        Expression value = null;


        Token x=null;
        Expression e =null;

        Expression r =null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:135:2: ( '.' x= ID ( '(' (e= expr ( ',' e= expr )* )? ')' )? r= access[value] |)
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            else if ( (LA22_0==EOF||LA22_0==THEN||(LA22_0 >= 27 && LA22_0 <= 28)||(LA22_0 >= 30 && LA22_0 <= 34)||(LA22_0 >= 36 && LA22_0 <= 43)||(LA22_0 >= 45 && LA22_0 <= 46)) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:135:4: '.' x= ID ( '(' (e= expr ( ',' e= expr )* )? ')' )? r= access[value]
                    {
                    match(input,35,FOLLOW_35_in_access821); 

                    x=(Token)match(input,ID,FOLLOW_ID_in_access825); 

                    value = f.Prop(base, x.getText()); 

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:136:6: ( '(' (e= expr ( ',' e= expr )* )? ')' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==29) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:136:8: '(' (e= expr ( ',' e= expr )* )? ')'
                            {
                            match(input,29,FOLLOW_29_in_access837); 

                             List<Expression> args = new ArrayList(); 

                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:137:4: (e= expr ( ',' e= expr )* )?
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==DATE||(LA20_0 >= FALSE && LA20_0 <= FLOAT)||LA20_0==FUNCTION||(LA20_0 >= ID && LA20_0 <= IF)||(LA20_0 >= INT && LA20_0 <= STRING)||LA20_0==TRUE||LA20_0==29) ) {
                                alt20=1;
                            }
                            switch (alt20) {
                                case 1 :
                                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:137:6: e= expr ( ',' e= expr )*
                                    {
                                    pushFollow(FOLLOW_expr_in_access848);
                                    e=expr();

                                    state._fsp--;


                                     args.add(e); 

                                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:138:6: ( ',' e= expr )*
                                    loop19:
                                    do {
                                        int alt19=2;
                                        int LA19_0 = input.LA(1);

                                        if ( (LA19_0==33) ) {
                                            alt19=1;
                                        }


                                        switch (alt19) {
                                    	case 1 :
                                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:138:7: ',' e= expr
                                    	    {
                                    	    match(input,33,FOLLOW_33_in_access858); 

                                    	    pushFollow(FOLLOW_expr_in_access862);
                                    	    e=expr();

                                    	    state._fsp--;


                                    	    args.add(e); 

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop19;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            match(input,30,FOLLOW_30_in_access880); 

                            value = f.Call(base, x.getText(), args); 

                            }
                            break;

                    }


                    pushFollow(FOLLOW_access_in_access899);
                    r=access(value);

                    state._fsp--;


                     value = r; 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:143:5: 
                    {
                    value = base; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "access"

    // Delegated rules


 

    public static final BitSet FOLLOW_statements_in_main133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statements154 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_statements159 = new BitSet(new long[]{0x00000000215DBC42L});
    public static final BitSet FOLLOW_statements_in_statements164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statements175 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_statements179 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_statements181 = new BitSet(new long[]{0x00000000205DAC40L});
    public static final BitSet FOLLOW_expr_in_statements185 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_statements187 = new BitSet(new long[]{0x00000000215DBC40L});
    public static final BitSet FOLLOW_statements_in_statements191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_block215 = new BitSet(new long[]{0x00000000215DBC40L});
    public static final BitSet FOLLOW_statements_in_block219 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_block221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_statement243 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_statement245 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_statement249 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_IN_in_statement251 = new BitSet(new long[]{0x00000000205DAC40L});
    public static final BitSet FOLLOW_expr_in_statement255 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement257 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_block_in_statement261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_statement271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_expr288 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_expr290 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_expr294 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_expr296 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_block_in_expr300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_in_expr313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_in_or334 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_or339 = new BitSet(new long[]{0x00000000205D8C40L});
    public static final BitSet FOLLOW_or_in_or343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comp_in_and363 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_and368 = new BitSet(new long[]{0x00000000205D8C40L});
    public static final BitSet FOLLOW_and_in_and372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_comp395 = new BitSet(new long[]{0x00000EC008000002L});
    public static final BitSet FOLLOW_compop_in_comp402 = new BitSet(new long[]{0x00000000205D8C40L});
    public static final BitSet FOLLOW_comp_in_comp406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_compop425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_compop433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_compop441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_compop450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_compop459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_compop468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term488 = new BitSet(new long[]{0x0000000500000002L});
    public static final BitSet FOLLOW_addop_in_term495 = new BitSet(new long[]{0x00000000205D8C40L});
    public static final BitSet FOLLOW_term_in_term499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_addop520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_addop528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_base_in_factor548 = new BitSet(new long[]{0x0000001080000002L});
    public static final BitSet FOLLOW_mulop_in_factor555 = new BitSet(new long[]{0x00000000205D8C40L});
    public static final BitSet FOLLOW_factor_in_factor559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_mulop578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_mulop586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_not605 = new BitSet(new long[]{0x00000000245D8C40L});
    public static final BitSet FOLLOW_not_in_not609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comp_in_not618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prim_in_base641 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_base646 = new BitSet(new long[]{0x00000000205DAC40L});
    public static final BitSet FOLLOW_expr_in_base650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_base659 = new BitSet(new long[]{0x00000000205DAC40L});
    public static final BitSet FOLLOW_expr_in_base663 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_THEN_in_base665 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_block_in_base669 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ELSE_in_base672 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_block_in_base676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_base688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_base697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_in_base704 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_base706 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_in_base710 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_base712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_base721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_base730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_base739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_base745 = new BitSet(new long[]{0x00000000205DAC40L});
    public static final BitSet FOLLOW_expr_in_base749 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_base751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_prim770 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_prim772 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_in_prim776 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_prim778 = new BitSet(new long[]{0x00000000205DAC40L});
    public static final BitSet FOLLOW_expr_in_prim782 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_prim784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_prim794 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_access_in_prim800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_access821 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ID_in_access825 = new BitSet(new long[]{0x0000000820000000L});
    public static final BitSet FOLLOW_29_in_access837 = new BitSet(new long[]{0x00000000605DAC40L});
    public static final BitSet FOLLOW_expr_in_access848 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_33_in_access858 = new BitSet(new long[]{0x00000000205DAC40L});
    public static final BitSet FOLLOW_expr_in_access862 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_30_in_access880 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_access_in_access899 = new BitSet(new long[]{0x0000000000000002L});

}