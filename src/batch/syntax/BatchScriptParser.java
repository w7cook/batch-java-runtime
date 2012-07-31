// $ANTLR 3.1.1 /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g 2012-07-30 19:35:17

package batch.syntax;


import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.*;

public class BatchScriptParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IF", "ELSE", "FOR", "FUNCTION", "OUTPUT", "VAR", "TRUE", "FALSE", "IN", "DATE", "ID", "INT", "STRING", "FLOAT", "DIGIT", "ALPHA", "EXPONENT", "COMMENT", "WS", "HEX_DIGIT", "UNICODE_ESC", "';'", "'='", "'{'", "'}'", "'('", "')'", "'||'", "'&&'", "'=='", "'!='", "'<='", "'<'", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'!'", "','", "'.'"
    };
    public static final int FUNCTION=7;
    public static final int EXPONENT=20;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int FOR=6;
    public static final int FLOAT=17;
    public static final int ID=14;
    public static final int EOF=-1;
    public static final int IF=4;
    public static final int IN=12;
    public static final int VAR=9;
    public static final int DIGIT=18;
    public static final int COMMENT=21;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int UNICODE_ESC=24;
    public static final int ELSE=5;
    public static final int HEX_DIGIT=23;
    public static final int INT=15;
    public static final int TRUE=10;
    public static final int ALPHA=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int WS=22;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int DATE=13;
    public static final int FALSE=11;
    public static final int OUTPUT=8;
    public static final int STRING=16;

    // delegates
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
            return parser.main();
          }




    // $ANTLR start "main"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:38:1: main returns [Expression value] : e= statements EOF ;
    public final Expression main() throws RecognitionException {
        Expression value = null;

        Expression e = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:39:2: (e= statements EOF )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:39:4: e= statements EOF
            {
            pushFollow(FOLLOW_statements_in_main125);
            e=statements();

            state._fsp--;

             value = e; 
            match(input,EOF,FOLLOW_EOF_in_main129); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "main"


    // $ANTLR start "statements"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:42:1: statements returns [Expression value] : (e= statement ( ';' (es= statements )? )? | VAR x= ID '=' e= expr ';' b= statements );
    public final Expression statements() throws RecognitionException {
        Expression value = null;

        Token x=null;
        Expression e = null;

        Expression es = null;

        Expression b = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:43:2: (e= statement ( ';' (es= statements )? )? | VAR x= ID '=' e= expr ';' b= statements )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IF||(LA3_0>=FOR && LA3_0<=OUTPUT)||(LA3_0>=TRUE && LA3_0<=FALSE)||(LA3_0>=DATE && LA3_0<=FLOAT)||LA3_0==29||LA3_0==43) ) {
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
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:43:4: e= statement ( ';' (es= statements )? )?
                    {
                    pushFollow(FOLLOW_statement_in_statements146);
                    e=statement();

                    state._fsp--;

                    value = e;
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:44:4: ( ';' (es= statements )? )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==25) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:44:5: ';' (es= statements )?
                            {
                            match(input,25,FOLLOW_25_in_statements155); 
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:45:6: (es= statements )?
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( (LA1_0==IF||(LA1_0>=FOR && LA1_0<=FALSE)||(LA1_0>=DATE && LA1_0<=FLOAT)||LA1_0==29||LA1_0==43) ) {
                                alt1=1;
                            }
                            switch (alt1) {
                                case 1 :
                                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:45:7: es= statements
                                    {
                                    pushFollow(FOLLOW_statements_in_statements166);
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
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:48:4: VAR x= ID '=' e= expr ';' b= statements
                    {
                    match(input,VAR,FOLLOW_VAR_in_statements187); 
                    x=(Token)match(input,ID,FOLLOW_ID_in_statements191); 
                    match(input,26,FOLLOW_26_in_statements193); 
                    pushFollow(FOLLOW_expr_in_statements197);
                    e=expr();

                    state._fsp--;

                    match(input,25,FOLLOW_25_in_statements199); 
                    pushFollow(FOLLOW_statements_in_statements203);
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
        }
        return value;
    }
    // $ANTLR end "statements"


    // $ANTLR start "block"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:51:1: block returns [Expression value] : '{' e= statements '}' ;
    public final Expression block() throws RecognitionException {
        Expression value = null;

        Expression e = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:52:5: ( '{' e= statements '}' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:52:7: '{' e= statements '}'
            {
            match(input,27,FOLLOW_27_in_block227); 
            pushFollow(FOLLOW_statements_in_block231);
            e=statements();

            state._fsp--;

            match(input,28,FOLLOW_28_in_block233); 
            value = e;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "block"


    // $ANTLR start "statement"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:55:1: statement returns [Expression value] : ( FOR '(' x= ID IN e= expr ')' b= block | e= expr );
    public final Expression statement() throws RecognitionException {
        Expression value = null;

        Token x=null;
        Expression e = null;

        Expression b = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:56:2: ( FOR '(' x= ID IN e= expr ')' b= block | e= expr )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==FOR) ) {
                alt4=1;
            }
            else if ( (LA4_0==IF||(LA4_0>=FUNCTION && LA4_0<=OUTPUT)||(LA4_0>=TRUE && LA4_0<=FALSE)||(LA4_0>=DATE && LA4_0<=FLOAT)||LA4_0==29||LA4_0==43) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:56:4: FOR '(' x= ID IN e= expr ')' b= block
                    {
                    match(input,FOR,FOLLOW_FOR_in_statement255); 
                    match(input,29,FOLLOW_29_in_statement257); 
                    x=(Token)match(input,ID,FOLLOW_ID_in_statement261); 
                    match(input,IN,FOLLOW_IN_in_statement263); 
                    pushFollow(FOLLOW_expr_in_statement267);
                    e=expr();

                    state._fsp--;

                    match(input,30,FOLLOW_30_in_statement269); 
                    pushFollow(FOLLOW_block_in_statement273);
                    b=block();

                    state._fsp--;

                     value = f.Loop(x.getText(), e, b); 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:57:4: e= expr
                    {
                    pushFollow(FOLLOW_expr_in_statement283);
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
        }
        return value;
    }
    // $ANTLR end "statement"


    // $ANTLR start "expr"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:60:1: expr returns [Expression value] : ( FUNCTION '(' x= ID ')' e= block | e= or );
    public final Expression expr() throws RecognitionException {
        Expression value = null;

        Token x=null;
        Expression e = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:61:2: ( FUNCTION '(' x= ID ')' e= block | e= or )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==FUNCTION) ) {
                alt5=1;
            }
            else if ( (LA5_0==IF||LA5_0==OUTPUT||(LA5_0>=TRUE && LA5_0<=FALSE)||(LA5_0>=DATE && LA5_0<=FLOAT)||LA5_0==29||LA5_0==43) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:61:4: FUNCTION '(' x= ID ')' e= block
                    {
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expr300); 
                    match(input,29,FOLLOW_29_in_expr302); 
                    x=(Token)match(input,ID,FOLLOW_ID_in_expr306); 
                    match(input,30,FOLLOW_30_in_expr308); 
                    pushFollow(FOLLOW_block_in_expr312);
                    e=block();

                    state._fsp--;

                     value = f.Fun(x.getText(), e); 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:62:4: e= or
                    {
                    pushFollow(FOLLOW_or_in_expr325);
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
        }
        return value;
    }
    // $ANTLR end "expr"


    // $ANTLR start "or"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:65:1: or returns [Expression value] : a= and ( '||' b= or )? ;
    public final Expression or() throws RecognitionException {
        Expression value = null;

        Expression a = null;

        Expression b = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:66:2: (a= and ( '||' b= or )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:66:4: a= and ( '||' b= or )?
            {
            pushFollow(FOLLOW_and_in_or346);
            a=and();

            state._fsp--;

            value=a;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:66:21: ( '||' b= or )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==31) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:66:22: '||' b= or
                    {
                    match(input,31,FOLLOW_31_in_or351); 
                    pushFollow(FOLLOW_or_in_or355);
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
        }
        return value;
    }
    // $ANTLR end "or"


    // $ANTLR start "and"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:68:1: and returns [Expression value] : a= comp ( '&&' b= and )? ;
    public final Expression and() throws RecognitionException {
        Expression value = null;

        Expression a = null;

        Expression b = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:69:2: (a= comp ( '&&' b= and )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:69:4: a= comp ( '&&' b= and )?
            {
            pushFollow(FOLLOW_comp_in_and375);
            a=comp();

            state._fsp--;

            value=a;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:69:22: ( '&&' b= and )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==32) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:69:23: '&&' b= and
                    {
                    match(input,32,FOLLOW_32_in_and380); 
                    pushFollow(FOLLOW_and_in_and384);
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
        }
        return value;
    }
    // $ANTLR end "and"


    // $ANTLR start "comp"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:72:1: comp returns [Expression value] : a= term (op= compop b= comp )? ;
    public final Expression comp() throws RecognitionException {
        Expression value = null;

        Expression a = null;

        batch.Op op = null;

        Expression b = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:73:2: (a= term (op= compop b= comp )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:73:4: a= term (op= compop b= comp )?
            {
            pushFollow(FOLLOW_term_in_comp407);
            a=term();

            state._fsp--;

            value=a;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:73:22: (op= compop b= comp )?
            int alt8=2;
            switch ( input.LA(1) ) {
                case 33:
                    {
                    alt8=1;
                    }
                    break;
                case 34:
                    {
                    alt8=1;
                    }
                    break;
                case 35:
                    {
                    alt8=1;
                    }
                    break;
                case 36:
                    {
                    alt8=1;
                    }
                    break;
                case 37:
                    {
                    alt8=1;
                    }
                    break;
                case 38:
                    {
                    alt8=1;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:73:23: op= compop b= comp
                    {
                    pushFollow(FOLLOW_compop_in_comp414);
                    op=compop();

                    state._fsp--;

                    pushFollow(FOLLOW_comp_in_comp418);
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
        }
        return value;
    }
    // $ANTLR end "comp"


    // $ANTLR start "compop"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:75:1: compop returns [batch.Op op] : ( '==' | '!=' | '<=' | '<' | '>' | '>=' );
    public final batch.Op compop() throws RecognitionException {
        batch.Op op = null;

        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:76:3: ( '==' | '!=' | '<=' | '<' | '>' | '>=' )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt9=1;
                }
                break;
            case 34:
                {
                alt9=2;
                }
                break;
            case 35:
                {
                alt9=3;
                }
                break;
            case 36:
                {
                alt9=4;
                }
                break;
            case 37:
                {
                alt9=5;
                }
                break;
            case 38:
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
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:76:5: '=='
                    {
                    match(input,33,FOLLOW_33_in_compop437); 
                     op = batch.Op.EQ; 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:77:5: '!='
                    {
                    match(input,34,FOLLOW_34_in_compop445); 
                     op = batch.Op.NE; 

                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:78:5: '<='
                    {
                    match(input,35,FOLLOW_35_in_compop453); 
                     op = batch.Op.LE; 

                    }
                    break;
                case 4 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:79:5: '<'
                    {
                    match(input,36,FOLLOW_36_in_compop462); 
                     op = batch.Op.LT; 

                    }
                    break;
                case 5 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:80:5: '>'
                    {
                    match(input,37,FOLLOW_37_in_compop471); 
                     op = batch.Op.GT; 

                    }
                    break;
                case 6 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:81:5: '>='
                    {
                    match(input,38,FOLLOW_38_in_compop480); 
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
        }
        return op;
    }
    // $ANTLR end "compop"


    // $ANTLR start "term"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:84:1: term returns [Expression value] : a= factor (op= addop b= term )? ;
    public final Expression term() throws RecognitionException {
        Expression value = null;

        Expression a = null;

        batch.Op op = null;

        Expression b = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:85:2: (a= factor (op= addop b= term )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:85:4: a= factor (op= addop b= term )?
            {
            pushFollow(FOLLOW_factor_in_term500);
            a=factor();

            state._fsp--;

            value=a;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:85:24: (op= addop b= term )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==39) ) {
                alt10=1;
            }
            else if ( (LA10_0==40) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:85:25: op= addop b= term
                    {
                    pushFollow(FOLLOW_addop_in_term507);
                    op=addop();

                    state._fsp--;

                    pushFollow(FOLLOW_term_in_term511);
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
        }
        return value;
    }
    // $ANTLR end "term"


    // $ANTLR start "addop"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:87:1: addop returns [batch.Op op] : ( '+' | '-' );
    public final batch.Op addop() throws RecognitionException {
        batch.Op op = null;

        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:88:3: ( '+' | '-' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==39) ) {
                alt11=1;
            }
            else if ( (LA11_0==40) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:88:5: '+'
                    {
                    match(input,39,FOLLOW_39_in_addop532); 
                     op = batch.Op.ADD; 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:89:5: '-'
                    {
                    match(input,40,FOLLOW_40_in_addop540); 
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
        }
        return op;
    }
    // $ANTLR end "addop"


    // $ANTLR start "factor"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:92:1: factor returns [Expression value] : a= base (op= mulop b= factor )? ;
    public final Expression factor() throws RecognitionException {
        Expression value = null;

        Expression a = null;

        batch.Op op = null;

        Expression b = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:93:2: (a= base (op= mulop b= factor )? )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:93:4: a= base (op= mulop b= factor )?
            {
            pushFollow(FOLLOW_base_in_factor560);
            a=base();

            state._fsp--;

            value=a;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:93:22: (op= mulop b= factor )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==41) ) {
                alt12=1;
            }
            else if ( (LA12_0==42) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:93:23: op= mulop b= factor
                    {
                    pushFollow(FOLLOW_mulop_in_factor567);
                    op=mulop();

                    state._fsp--;

                    pushFollow(FOLLOW_factor_in_factor571);
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
        }
        return value;
    }
    // $ANTLR end "factor"


    // $ANTLR start "mulop"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:95:1: mulop returns [batch.Op op] : ( '*' | '/' );
    public final batch.Op mulop() throws RecognitionException {
        batch.Op op = null;

        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:96:3: ( '*' | '/' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==41) ) {
                alt13=1;
            }
            else if ( (LA13_0==42) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:96:5: '*'
                    {
                    match(input,41,FOLLOW_41_in_mulop590); 
                     op = batch.Op.MUL; 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:97:5: '/'
                    {
                    match(input,42,FOLLOW_42_in_mulop598); 
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
        }
        return op;
    }
    // $ANTLR end "mulop"


    // $ANTLR start "base"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:100:1: base returns [Expression value] : ( '!' e= base | a= prim ( '=' b= expr )? | IF '(' a= expr ')' t= block ( ELSE e= block )? | x= INT | x= STRING | DATE '(' x= STRING ')' | x= FLOAT | x= TRUE | x= FALSE | '(' e= expr ')' );
    public final Expression base() throws RecognitionException {
        Expression value = null;

        Token x=null;
        Expression e = null;

        Expression a = null;

        Expression b = null;

        Expression t = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:101:4: ( '!' e= base | a= prim ( '=' b= expr )? | IF '(' a= expr ')' t= block ( ELSE e= block )? | x= INT | x= STRING | DATE '(' x= STRING ')' | x= FLOAT | x= TRUE | x= FALSE | '(' e= expr ')' )
            int alt16=10;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt16=1;
                }
                break;
            case OUTPUT:
            case ID:
                {
                alt16=2;
                }
                break;
            case IF:
                {
                alt16=3;
                }
                break;
            case INT:
                {
                alt16=4;
                }
                break;
            case STRING:
                {
                alt16=5;
                }
                break;
            case DATE:
                {
                alt16=6;
                }
                break;
            case FLOAT:
                {
                alt16=7;
                }
                break;
            case TRUE:
                {
                alt16=8;
                }
                break;
            case FALSE:
                {
                alt16=9;
                }
                break;
            case 29:
                {
                alt16=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:101:7: '!' e= base
                    {
                    match(input,43,FOLLOW_43_in_base620); 
                    pushFollow(FOLLOW_base_in_base624);
                    e=base();

                    state._fsp--;

                    value=f.Prim(batch.Op.NOT, e); 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:102:4: a= prim ( '=' b= expr )?
                    {
                    pushFollow(FOLLOW_prim_in_base633);
                    a=prim();

                    state._fsp--;

                    value=a;
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:102:22: ( '=' b= expr )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==26) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:102:23: '=' b= expr
                            {
                            match(input,26,FOLLOW_26_in_base638); 
                            pushFollow(FOLLOW_expr_in_base642);
                            b=expr();

                            state._fsp--;

                             value=f.Assign(a, b); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:103:4: IF '(' a= expr ')' t= block ( ELSE e= block )?
                    {
                    match(input,IF,FOLLOW_IF_in_base651); 
                    match(input,29,FOLLOW_29_in_base653); 
                    pushFollow(FOLLOW_expr_in_base657);
                    a=expr();

                    state._fsp--;

                    match(input,30,FOLLOW_30_in_base659); 
                    pushFollow(FOLLOW_block_in_base663);
                    t=block();

                    state._fsp--;

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:103:30: ( ELSE e= block )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==ELSE) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:103:31: ELSE e= block
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_base666); 
                            pushFollow(FOLLOW_block_in_base670);
                            e=block();

                            state._fsp--;


                            }
                            break;

                    }

                     value = f.If(a, t, e == null ? f.Skip() : e); 

                    }
                    break;
                case 4 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:104:4: x= INT
                    {
                    x=(Token)match(input,INT,FOLLOW_INT_in_base682); 
                     value = f.Data(Integer.parseInt(x.getText())); 

                    }
                    break;
                case 5 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:105:4: x= STRING
                    {
                    x=(Token)match(input,STRING,FOLLOW_STRING_in_base691); 
                     
                    		String str = x.getText();
                    		str = str.substring(1, str.length() - 1);
                    		str = str.replace("\\\"", "\"");
                    		str = str.replace("\\\\", "\\");
                    		value = f.Data(str); 

                    }
                    break;
                case 6 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:111:4: DATE '(' x= STRING ')'
                    {
                    match(input,DATE,FOLLOW_DATE_in_base698); 
                    match(input,29,FOLLOW_29_in_base700); 
                    x=(Token)match(input,STRING,FOLLOW_STRING_in_base704); 
                    match(input,30,FOLLOW_30_in_base706); 
                     
                    		String str = x.getText();
                    		str = str.substring(1, str.length() - 1);
                    		value = f.Data(java.sql.Date.valueOf(str)); 
                    		

                    }
                    break;
                case 7 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:116:4: x= FLOAT
                    {
                    x=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_base715); 
                     value = f.Data(Float.parseFloat(x.getText())); 

                    }
                    break;
                case 8 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:117:4: x= TRUE
                    {
                    x=(Token)match(input,TRUE,FOLLOW_TRUE_in_base724); 
                     value = f.Data(true); 

                    }
                    break;
                case 9 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:118:4: x= FALSE
                    {
                    x=(Token)match(input,FALSE,FOLLOW_FALSE_in_base733); 
                     value = f.Data(false); 

                    }
                    break;
                case 10 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:119:4: '(' e= expr ')'
                    {
                    match(input,29,FOLLOW_29_in_base739); 
                    pushFollow(FOLLOW_expr_in_base743);
                    e=expr();

                    state._fsp--;

                    match(input,30,FOLLOW_30_in_base745); 
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
        }
        return value;
    }
    // $ANTLR end "base"


    // $ANTLR start "prim"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:122:1: prim returns [Expression value] : ( OUTPUT '(' b= STRING ',' e= expr ')' | b= ID r= access[value] );
    public final Expression prim() throws RecognitionException {
        Expression value = null;

        Token b=null;
        Expression e = null;

        Expression r = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:123:3: ( OUTPUT '(' b= STRING ',' e= expr ')' | b= ID r= access[value] )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==OUTPUT) ) {
                alt17=1;
            }
            else if ( (LA17_0==ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:123:5: OUTPUT '(' b= STRING ',' e= expr ')'
                    {
                    match(input,OUTPUT,FOLLOW_OUTPUT_in_prim764); 
                    match(input,29,FOLLOW_29_in_prim766); 
                    b=(Token)match(input,STRING,FOLLOW_STRING_in_prim770); 
                    match(input,44,FOLLOW_44_in_prim772); 
                    pushFollow(FOLLOW_expr_in_prim776);
                    e=expr();

                    state._fsp--;

                    match(input,30,FOLLOW_30_in_prim778); 
                     
                      		String str = b.getText();
                    		str = str.substring(1, str.length() - 1);
                    		value = f.Out(str, e); 
                    	

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:128:5: b= ID r= access[value]
                    {
                    b=(Token)match(input,ID,FOLLOW_ID_in_prim788); 
                     value = f.Var(b.getText()); 
                    pushFollow(FOLLOW_access_in_prim794);
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
        }
        return value;
    }
    // $ANTLR end "prim"


    // $ANTLR start "access"
    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:132:1: access[Expression base] returns [Expression value] : ( '.' x= ID ( '(' (e= expr ( ',' e= expr )* )? ')' )? r= access[value] | );
    public final Expression access(Expression base) throws RecognitionException {
        Expression value = null;

        Token x=null;
        Expression e = null;

        Expression r = null;


        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:133:2: ( '.' x= ID ( '(' (e= expr ( ',' e= expr )* )? ')' )? r= access[value] | )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==45) ) {
                alt21=1;
            }
            else if ( (LA21_0==EOF||(LA21_0>=25 && LA21_0<=26)||LA21_0==28||(LA21_0>=30 && LA21_0<=42)||LA21_0==44) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:133:4: '.' x= ID ( '(' (e= expr ( ',' e= expr )* )? ')' )? r= access[value]
                    {
                    match(input,45,FOLLOW_45_in_access815); 
                    x=(Token)match(input,ID,FOLLOW_ID_in_access819); 
                    value = f.Prop(base, x.getText()); 
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:134:6: ( '(' (e= expr ( ',' e= expr )* )? ')' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==29) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:134:8: '(' (e= expr ( ',' e= expr )* )? ')'
                            {
                            match(input,29,FOLLOW_29_in_access831); 
                             List<Expression> args = new ArrayList<Expression>(); 
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:135:4: (e= expr ( ',' e= expr )* )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==IF||(LA19_0>=FUNCTION && LA19_0<=OUTPUT)||(LA19_0>=TRUE && LA19_0<=FALSE)||(LA19_0>=DATE && LA19_0<=FLOAT)||LA19_0==29||LA19_0==43) ) {
                                alt19=1;
                            }
                            switch (alt19) {
                                case 1 :
                                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:135:6: e= expr ( ',' e= expr )*
                                    {
                                    pushFollow(FOLLOW_expr_in_access842);
                                    e=expr();

                                    state._fsp--;

                                     args.add(e); 
                                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:136:6: ( ',' e= expr )*
                                    loop18:
                                    do {
                                        int alt18=2;
                                        int LA18_0 = input.LA(1);

                                        if ( (LA18_0==44) ) {
                                            alt18=1;
                                        }


                                        switch (alt18) {
                                    	case 1 :
                                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:136:7: ',' e= expr
                                    	    {
                                    	    match(input,44,FOLLOW_44_in_access852); 
                                    	    pushFollow(FOLLOW_expr_in_access856);
                                    	    e=expr();

                                    	    state._fsp--;

                                    	    args.add(e); 

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop18;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            match(input,30,FOLLOW_30_in_access874); 
                            value = f.Call(base, x.getText(), args); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_access_in_access893);
                    r=access(value);

                    state._fsp--;

                     value = r; 

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:141:5: 
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
        }
        return value;
    }
    // $ANTLR end "access"

    // Delegated rules


 

    public static final BitSet FOLLOW_statements_in_main125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statements146 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_statements155 = new BitSet(new long[]{0x000008002003EFD2L});
    public static final BitSet FOLLOW_statements_in_statements166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_statements187 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ID_in_statements191 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statements193 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_expr_in_statements197 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statements199 = new BitSet(new long[]{0x000008002003EFD0L});
    public static final BitSet FOLLOW_statements_in_statements203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_block227 = new BitSet(new long[]{0x000008002003EFD0L});
    public static final BitSet FOLLOW_statements_in_block231 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_block233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_statement255 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_statement257 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ID_in_statement261 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IN_in_statement263 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_expr_in_statement267 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement269 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_block_in_statement273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_statement283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_expr300 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_expr302 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ID_in_expr306 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_expr308 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_block_in_expr312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_in_expr325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_in_or346 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_or351 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_or_in_or355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comp_in_and375 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_and380 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_and_in_and384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_comp407 = new BitSet(new long[]{0x0000007E00000002L});
    public static final BitSet FOLLOW_compop_in_comp414 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_comp_in_comp418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_compop437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_compop445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_compop453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_compop462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_compop471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_compop480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term500 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_addop_in_term507 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_term_in_term511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_addop532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_addop540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_base_in_factor560 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_mulop_in_factor567 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_factor_in_factor571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_mulop590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_mulop598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_base620 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_base_in_base624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prim_in_base633 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_base638 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_expr_in_base642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_base651 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_base653 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_expr_in_base657 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_base659 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_block_in_base663 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ELSE_in_base666 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_block_in_base670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_base682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_base691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_in_base698 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_base700 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_base704 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_base706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_base715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_base724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_base733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_base739 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_expr_in_base743 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_base745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_prim764 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_prim766 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_prim770 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_prim772 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_expr_in_prim776 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_prim778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_prim788 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_access_in_prim794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_access815 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ID_in_access819 = new BitSet(new long[]{0x0000200020000000L});
    public static final BitSet FOLLOW_29_in_access831 = new BitSet(new long[]{0x000008006003EDD0L});
    public static final BitSet FOLLOW_expr_in_access842 = new BitSet(new long[]{0x0000100040000000L});
    public static final BitSet FOLLOW_44_in_access852 = new BitSet(new long[]{0x000008002003EDD0L});
    public static final BitSet FOLLOW_expr_in_access856 = new BitSet(new long[]{0x0000100040000000L});
    public static final BitSet FOLLOW_30_in_access874 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_access_in_access893 = new BitSet(new long[]{0x0000000000000002L});

}