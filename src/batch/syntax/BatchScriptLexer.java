// $ANTLR 3.4 /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g 2012-07-28 14:40:01

package batch.syntax;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class BatchScriptLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public BatchScriptLexer() {} 
    public BatchScriptLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BatchScriptLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g"; }

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:6:6: ( 'date' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:6:8: 'date'
            {
            match("date"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATE"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:7:6: ( 'else' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:7:8: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:8:7: ( 'false' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:8:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:9:5: ( 'for' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:9:7: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:10:10: ( 'function' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:10:12: 'function'
            {
            match("function"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:11:4: ( 'if' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:11:6: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:12:4: ( 'in' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:12:6: 'in'
            {
            match("in"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "OUTPUT"
    public final void mOUTPUT() throws RecognitionException {
        try {
            int _type = OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:13:8: ( 'OUTPUT' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:13:10: 'OUTPUT'
            {
            match("OUTPUT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTPUT"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:14:6: ( 'then' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:14:8: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:15:6: ( 'true' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:15:8: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:16:5: ( 'var' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:16:7: 'var'
            {
            match("var"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:17:7: ( '!' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:17:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:18:7: ( '!=' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:18:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:19:7: ( '&&' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:19:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:20:7: ( '(' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:20:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:21:7: ( ')' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:21:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:22:7: ( '*' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:22:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:23:7: ( '+' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:23:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:24:7: ( ',' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:24:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:25:7: ( '-' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:25:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:26:7: ( '.' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:26:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:27:7: ( '/' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:27:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:28:7: ( ';' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:28:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:29:7: ( '<' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:29:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:30:7: ( '<=' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:30:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:31:7: ( '=' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:31:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:32:7: ( '==' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:32:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:33:7: ( '>' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:33:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:34:7: ( '>=' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:34:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:35:7: ( '{' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:35:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:36:7: ( '||' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:36:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:37:7: ( '}' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:37:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:147:16: ( '0' .. '9' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:148:16: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:150:5: ( ALPHA ( ALPHA | DIGIT )* )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:150:7: ALPHA ( ALPHA | DIGIT )*
            {
            mALPHA(); 


            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:150:13: ( ALPHA | DIGIT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:153:5: ( ( '-' )? ( DIGIT )+ )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:153:7: ( '-' )? ( DIGIT )+
            {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:153:7: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:153:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:153:12: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:5: ( ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )? | ( '-' )? '.' ( DIGIT )+ ( EXPONENT )? | ( '-' )? ( DIGIT )+ EXPONENT )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:9: ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )?
                    {
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:9: ( '-' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='-') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:14: ( DIGIT )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    match('.'); 

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:25: ( DIGIT )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:32: ( EXPONENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='E'||LA7_0=='e') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:32: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:158:9: ( '-' )? '.' ( DIGIT )+ ( EXPONENT )?
                    {
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:158:9: ( '-' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='-') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:158:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    match('.'); 

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:158:18: ( DIGIT )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:158:25: ( EXPONENT )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:158:25: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:159:9: ( '-' )? ( DIGIT )+ EXPONENT
                    {
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:159:9: ( '-' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='-') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:159:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:159:14: ( DIGIT )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    mEXPONENT(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:163:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='/') ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1=='/') ) {
                    alt17=1;
                }
                else if ( (LA17_1=='*') ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:163:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:163:14: (~ ( '\\n' | '\\r' ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0 >= '\u0000' && LA14_0 <= '\t')||(LA14_0 >= '\u000B' && LA14_0 <= '\f')||(LA14_0 >= '\u000E' && LA14_0 <= '\uFFFF')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:163:28: ( '\\r' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='\r') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:163:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:164:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:164:14: ( options {greedy=false; } : . )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='*') ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1=='/') ) {
                                alt16=2;
                            }
                            else if ( ((LA16_1 >= '\u0000' && LA16_1 <= '.')||(LA16_1 >= '0' && LA16_1 <= '\uFFFF')) ) {
                                alt16=1;
                            }


                        }
                        else if ( ((LA16_0 >= '\u0000' && LA16_0 <= ')')||(LA16_0 >= '+' && LA16_0 <= '\uFFFF')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:164:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:167:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:167:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:176:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:176:12: ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:176:22: ( '+' | '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='+'||LA18_0=='-') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:176:33: ( DIGIT )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0 >= '0' && LA19_0 <= '9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:179:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:184:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:184:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:187:5: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC |~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:187:8: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:187:12: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC |~ ( '\\\\' | '\"' ) )*
            loop20:
            do {
                int alt20=4;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='\\') ) {
                    int LA20_2 = input.LA(2);

                    if ( (LA20_2=='\"'||LA20_2=='\''||LA20_2=='\\'||LA20_2=='b'||LA20_2=='f'||LA20_2=='n'||LA20_2=='r'||LA20_2=='t') ) {
                        alt20=1;
                    }
                    else if ( (LA20_2=='u') ) {
                        alt20=2;
                    }


                }
                else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '!')||(LA20_0 >= '#' && LA20_0 <= '[')||(LA20_0 >= ']' && LA20_0 <= '\uFFFF')) ) {
                    alt20=3;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:187:14: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 

            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:187:58: UNICODE_ESC
            	    {
            	    mUNICODE_ESC(); 


            	    }
            	    break;
            	case 3 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:187:72: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:8: ( DATE | ELSE | FALSE | FOR | FUNCTION | IF | IN | OUTPUT | THEN | TRUE | VAR | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | ID | INT | FLOAT | COMMENT | WS | STRING )
        int alt21=38;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:10: DATE
                {
                mDATE(); 


                }
                break;
            case 2 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:15: ELSE
                {
                mELSE(); 


                }
                break;
            case 3 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:20: FALSE
                {
                mFALSE(); 


                }
                break;
            case 4 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:26: FOR
                {
                mFOR(); 


                }
                break;
            case 5 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:30: FUNCTION
                {
                mFUNCTION(); 


                }
                break;
            case 6 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:39: IF
                {
                mIF(); 


                }
                break;
            case 7 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:42: IN
                {
                mIN(); 


                }
                break;
            case 8 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:45: OUTPUT
                {
                mOUTPUT(); 


                }
                break;
            case 9 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:52: THEN
                {
                mTHEN(); 


                }
                break;
            case 10 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:57: TRUE
                {
                mTRUE(); 


                }
                break;
            case 11 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:62: VAR
                {
                mVAR(); 


                }
                break;
            case 12 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:66: T__26
                {
                mT__26(); 


                }
                break;
            case 13 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:72: T__27
                {
                mT__27(); 


                }
                break;
            case 14 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:78: T__28
                {
                mT__28(); 


                }
                break;
            case 15 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:84: T__29
                {
                mT__29(); 


                }
                break;
            case 16 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:90: T__30
                {
                mT__30(); 


                }
                break;
            case 17 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:96: T__31
                {
                mT__31(); 


                }
                break;
            case 18 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:102: T__32
                {
                mT__32(); 


                }
                break;
            case 19 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:108: T__33
                {
                mT__33(); 


                }
                break;
            case 20 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:114: T__34
                {
                mT__34(); 


                }
                break;
            case 21 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:120: T__35
                {
                mT__35(); 


                }
                break;
            case 22 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:126: T__36
                {
                mT__36(); 


                }
                break;
            case 23 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:132: T__37
                {
                mT__37(); 


                }
                break;
            case 24 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:138: T__38
                {
                mT__38(); 


                }
                break;
            case 25 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:144: T__39
                {
                mT__39(); 


                }
                break;
            case 26 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:150: T__40
                {
                mT__40(); 


                }
                break;
            case 27 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:156: T__41
                {
                mT__41(); 


                }
                break;
            case 28 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:162: T__42
                {
                mT__42(); 


                }
                break;
            case 29 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:168: T__43
                {
                mT__43(); 


                }
                break;
            case 30 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:174: T__44
                {
                mT__44(); 


                }
                break;
            case 31 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:180: T__45
                {
                mT__45(); 


                }
                break;
            case 32 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:186: T__46
                {
                mT__46(); 


                }
                break;
            case 33 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:192: ID
                {
                mID(); 


                }
                break;
            case 34 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:195: INT
                {
                mINT(); 


                }
                break;
            case 35 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:199: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 36 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:205: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 37 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:213: WS
                {
                mWS(); 


                }
                break;
            case 38 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:216: STRING
                {
                mSTRING(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA13_eotS =
        "\6\uffff";
    static final String DFA13_eofS =
        "\6\uffff";
    static final String DFA13_minS =
        "\1\55\2\56\3\uffff";
    static final String DFA13_maxS =
        "\2\71\1\145\3\uffff";
    static final String DFA13_acceptS =
        "\3\uffff\1\2\1\1\1\3";
    static final String DFA13_specialS =
        "\6\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1\1\3\1\uffff\12\2",
            "\1\3\1\uffff\12\2",
            "\1\4\1\uffff\12\2\13\uffff\1\5\37\uffff\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "156:1: FLOAT : ( ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )? | ( '-' )? '.' ( DIGIT )+ ( EXPONENT )? | ( '-' )? ( DIGIT )+ EXPONENT );";
        }
    }
    static final String DFA21_eotS =
        "\1\uffff\7\31\1\51\6\uffff\1\52\1\54\1\56\1\uffff\1\60\1\62\1\64"+
        "\4\uffff\1\65\2\uffff\5\31\1\73\1\74\4\31\16\uffff\3\31\1\104\1"+
        "\31\2\uffff\3\31\1\111\1\112\1\113\1\31\1\uffff\2\31\1\117\1\120"+
        "\3\uffff\1\121\2\31\3\uffff\1\31\1\125\1\31\1\uffff\1\127\1\uffff";
    static final String DFA21_eofS =
        "\130\uffff";
    static final String DFA21_minS =
        "\1\11\1\141\1\154\1\141\1\146\1\125\1\150\1\141\1\75\6\uffff\1\56"+
        "\1\60\1\52\1\uffff\3\75\4\uffff\1\56\2\uffff\1\164\1\163\1\154\1"+
        "\162\1\156\2\60\1\124\1\145\1\165\1\162\16\uffff\2\145\1\163\1\60"+
        "\1\143\2\uffff\1\120\1\156\1\145\3\60\1\145\1\uffff\1\164\1\125"+
        "\2\60\3\uffff\1\60\1\151\1\124\3\uffff\1\157\1\60\1\156\1\uffff"+
        "\1\60\1\uffff";
    static final String DFA21_maxS =
        "\1\175\1\141\1\154\1\165\1\156\1\125\1\162\1\141\1\75\6\uffff\2"+
        "\71\1\57\1\uffff\3\75\4\uffff\1\145\2\uffff\1\164\1\163\1\154\1"+
        "\162\1\156\2\172\1\124\1\145\1\165\1\162\16\uffff\2\145\1\163\1"+
        "\172\1\143\2\uffff\1\120\1\156\1\145\3\172\1\145\1\uffff\1\164\1"+
        "\125\2\172\3\uffff\1\172\1\151\1\124\3\uffff\1\157\1\172\1\156\1"+
        "\uffff\1\172\1\uffff";
    static final String DFA21_acceptS =
        "\11\uffff\1\16\1\17\1\20\1\21\1\22\1\23\3\uffff\1\27\3\uffff\1\36"+
        "\1\37\1\40\1\41\1\uffff\1\45\1\46\13\uffff\1\15\1\14\1\24\1\43\1"+
        "\25\1\44\1\26\1\31\1\30\1\33\1\32\1\35\1\34\1\42\5\uffff\1\6\1\7"+
        "\7\uffff\1\4\4\uffff\1\13\1\1\1\2\3\uffff\1\11\1\12\1\3\3\uffff"+
        "\1\10\1\uffff\1\5";
    static final String DFA21_specialS =
        "\130\uffff}>";
    static final String[] DFA21_transitionS = {
            "\2\33\2\uffff\1\33\22\uffff\1\33\1\10\1\34\3\uffff\1\11\1\uffff"+
            "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\12\32\1\uffff\1\22"+
            "\1\23\1\24\1\25\2\uffff\16\31\1\5\13\31\4\uffff\1\31\1\uffff"+
            "\3\31\1\1\1\2\1\3\2\31\1\4\12\31\1\6\1\31\1\7\4\31\1\26\1\27"+
            "\1\30",
            "\1\35",
            "\1\36",
            "\1\37\15\uffff\1\40\5\uffff\1\41",
            "\1\42\7\uffff\1\43",
            "\1\44",
            "\1\45\11\uffff\1\46",
            "\1\47",
            "\1\50",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\53\1\uffff\12\32",
            "\12\53",
            "\1\55\4\uffff\1\55",
            "",
            "\1\57",
            "\1\61",
            "\1\63",
            "",
            "",
            "",
            "",
            "\1\53\1\uffff\12\32\13\uffff\1\53\37\uffff\1\53",
            "",
            "",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\101",
            "\1\102",
            "\1\103",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\105",
            "",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\122",
            "\1\123",
            "",
            "",
            "",
            "\1\124",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\126",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( DATE | ELSE | FALSE | FOR | FUNCTION | IF | IN | OUTPUT | THEN | TRUE | VAR | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | ID | INT | FLOAT | COMMENT | WS | STRING );";
        }
    }
 

}