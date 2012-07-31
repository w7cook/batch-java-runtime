// $ANTLR 3.1.1 /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g 2012-07-30 19:35:18

package batch.syntax;


import org.antlr.runtime.*;

public class BatchScriptLexer extends Lexer {
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

    public BatchScriptLexer() {;} 
    public BatchScriptLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BatchScriptLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g"; }

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:7:4: ( 'if' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:7:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:8:6: ( 'else' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:8:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

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
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "OUTPUT"
    public final void mOUTPUT() throws RecognitionException {
        try {
            int _type = OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:11:8: ( 'OUTPUT' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:11:10: 'OUTPUT'
            {
            match("OUTPUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTPUT"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:12:5: ( 'var' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:12:7: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:13:6: ( 'true' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:13:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:14:7: ( 'false' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:14:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:15:4: ( 'in' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:15:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:16:6: ( 'date' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:16:8: 'date'
            {
            match("date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DATE"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:17:7: ( ';' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:17:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:18:7: ( '=' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:18:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:19:7: ( '{' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:19:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:20:7: ( '}' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:20:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:21:7: ( '(' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:21:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:22:7: ( ')' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:22:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:23:7: ( '||' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:23:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:24:7: ( '&&' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:24:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:25:7: ( '==' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:25:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:26:7: ( '!=' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:26:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:27:7: ( '<=' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:27:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:28:7: ( '<' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:28:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:29:7: ( '>' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:29:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:30:7: ( '>=' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:30:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:31:7: ( '+' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:31:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:32:7: ( '-' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:32:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:33:7: ( '*' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:33:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:34:7: ( '/' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:34:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:35:7: ( '!' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:35:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:36:7: ( ',' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:36:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:37:7: ( '.' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:37:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:145:16: ( '0' .. '9' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:145:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:146:16: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt1=1;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                {
                alt1=2;
                }
                break;
            case '_':
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:146:18: ( 'a' .. 'z' )
                    {
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:146:18: ( 'a' .. 'z' )
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:146:19: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:146:31: ( 'A' .. 'Z' )
                    {
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:146:31: ( 'A' .. 'Z' )
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:146:32: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:146:44: '_'
                    {
                    match('_'); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:148:5: ( ALPHA ( ALPHA | DIGIT )* )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:148:7: ALPHA ( ALPHA | DIGIT )*
            {
            mALPHA(); 
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:148:13: ( ALPHA | DIGIT )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }
                else if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:148:14: ALPHA
            	    {
            	    mALPHA(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:148:20: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:151:5: ( ( '-' )? ( DIGIT )+ )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:151:7: ( '-' )? ( DIGIT )+
            {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:151:7: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:151:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:151:12: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:151:12: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:5: ( ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )? | ( '-' )? '.' ( DIGIT )+ ( EXPONENT )? | ( '-' )? ( DIGIT )+ EXPONENT )
            int alt14=3;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:9: ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )?
                    {
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:9: ( '-' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='-') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:14: ( DIGIT )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:14: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    match('.'); 
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:25: ( DIGIT )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:25: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:32: ( EXPONENT )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='E'||LA8_0=='e') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:155:32: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:156:9: ( '-' )? '.' ( DIGIT )+ ( EXPONENT )?
                    {
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:156:9: ( '-' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='-') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:156:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    match('.'); 
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:156:18: ( DIGIT )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:156:18: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:156:25: ( EXPONENT )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:156:25: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:9: ( '-' )? ( DIGIT )+ EXPONENT
                    {
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:9: ( '-' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='-') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:14: ( DIGIT )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:157:14: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);

                    mEXPONENT(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:161:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='/') ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1=='/') ) {
                    alt18=1;
                }
                else if ( (LA18_1=='*') ) {
                    alt18=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:161:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:161:14: (~ ( '\\n' | '\\r' ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:161:14: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:161:28: ( '\\r' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='\r') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:161:28: '\\r'
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
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:162:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:162:14: ( options {greedy=false; } : . )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0=='*') ) {
                            int LA17_1 = input.LA(2);

                            if ( (LA17_1=='/') ) {
                                alt17=2;
                            }
                            else if ( ((LA17_1>='\u0000' && LA17_1<='.')||(LA17_1>='0' && LA17_1<='\uFFFF')) ) {
                                alt17=1;
                            }


                        }
                        else if ( ((LA17_0>='\u0000' && LA17_0<=')')||(LA17_0>='+' && LA17_0<='\uFFFF')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:162:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
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
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:165:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:165:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:173:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:173:12: ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:173:22: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:173:33: ( DIGIT )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:173:33: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:176:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:176:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:181:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:181:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:185:5: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:185:8: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:185:12: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | ~ ( '\\\\' | '\"' ) )*
            loop21:
            do {
                int alt21=4;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\\') ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2=='\"'||LA21_2=='\''||LA21_2=='\\'||LA21_2=='b'||LA21_2=='f'||LA21_2=='n'||LA21_2=='r'||LA21_2=='t') ) {
                        alt21=1;
                    }
                    else if ( (LA21_2=='u') ) {
                        alt21=2;
                    }


                }
                else if ( ((LA21_0>='\u0000' && LA21_0<='!')||(LA21_0>='#' && LA21_0<='[')||(LA21_0>=']' && LA21_0<='\uFFFF')) ) {
                    alt21=3;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:185:14: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:185:58: UNICODE_ESC
            	    {
            	    mUNICODE_ESC(); 

            	    }
            	    break;
            	case 3 :
            	    // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:185:72: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:8: ( IF | ELSE | FOR | FUNCTION | OUTPUT | VAR | TRUE | FALSE | IN | DATE | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | ID | INT | FLOAT | COMMENT | WS | STRING )
        int alt22=37;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:10: IF
                {
                mIF(); 

                }
                break;
            case 2 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:13: ELSE
                {
                mELSE(); 

                }
                break;
            case 3 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:18: FOR
                {
                mFOR(); 

                }
                break;
            case 4 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:22: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 5 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:31: OUTPUT
                {
                mOUTPUT(); 

                }
                break;
            case 6 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:38: VAR
                {
                mVAR(); 

                }
                break;
            case 7 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:42: TRUE
                {
                mTRUE(); 

                }
                break;
            case 8 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:47: FALSE
                {
                mFALSE(); 

                }
                break;
            case 9 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:53: IN
                {
                mIN(); 

                }
                break;
            case 10 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:56: DATE
                {
                mDATE(); 

                }
                break;
            case 11 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:61: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:67: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:73: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:79: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:85: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:91: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:97: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:103: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:109: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:115: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:121: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:127: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:133: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:139: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:145: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:151: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:157: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:163: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:169: T__43
                {
                mT__43(); 

                }
                break;
            case 30 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:175: T__44
                {
                mT__44(); 

                }
                break;
            case 31 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:181: T__45
                {
                mT__45(); 

                }
                break;
            case 32 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:187: ID
                {
                mID(); 

                }
                break;
            case 33 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:190: INT
                {
                mINT(); 

                }
                break;
            case 34 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:194: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 35 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:200: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 36 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:208: WS
                {
                mWS(); 

                }
                break;
            case 37 :
                // /Users/wcook/workspace/batch-java-runtime/src/batch/syntax/BatchScript.g:1:211: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA14_eotS =
        "\6\uffff";
    static final String DFA14_eofS =
        "\6\uffff";
    static final String DFA14_minS =
        "\1\55\2\56\3\uffff";
    static final String DFA14_maxS =
        "\2\71\1\145\3\uffff";
    static final String DFA14_acceptS =
        "\3\uffff\1\2\1\1\1\3";
    static final String DFA14_specialS =
        "\6\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1\1\3\1\uffff\12\2",
            "\1\3\1\uffff\12\2",
            "\1\4\1\uffff\12\2\13\uffff\1\5\37\uffff\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "154:1: FLOAT : ( ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )? | ( '-' )? '.' ( DIGIT )+ ( EXPONENT )? | ( '-' )? ( DIGIT )+ EXPONENT );";
        }
    }
    static final String DFA22_eotS =
        "\1\uffff\7\31\1\uffff\1\50\6\uffff\1\52\1\54\1\56\1\uffff\1\57\1"+
        "\uffff\1\62\1\uffff\1\63\1\uffff\1\64\2\uffff\1\65\1\66\10\31\20"+
        "\uffff\1\31\1\100\3\31\1\104\2\31\1\107\1\uffff\3\31\1\uffff\1\113"+
        "\1\114\1\uffff\1\31\1\116\1\31\2\uffff\1\31\1\uffff\1\121\1\31\1"+
        "\uffff\1\123\1\uffff";
    static final String DFA22_eofS =
        "\124\uffff";
    static final String DFA22_minS =
        "\1\11\1\146\1\154\1\141\1\125\1\141\1\162\1\141\1\uffff\1\75\6\uffff"+
        "\3\75\1\uffff\1\56\1\uffff\1\52\1\uffff\1\60\1\uffff\1\56\2\uffff"+
        "\2\60\1\163\1\162\1\156\1\154\1\124\1\162\1\165\1\164\20\uffff\1"+
        "\145\1\60\1\143\1\163\1\120\1\60\2\145\1\60\1\uffff\1\164\1\145"+
        "\1\125\1\uffff\2\60\1\uffff\1\151\1\60\1\124\2\uffff\1\157\1\uffff"+
        "\1\60\1\156\1\uffff\1\60\1\uffff";
    static final String DFA22_maxS =
        "\1\175\1\156\1\154\1\165\1\125\1\141\1\162\1\141\1\uffff\1\75\6"+
        "\uffff\3\75\1\uffff\1\71\1\uffff\1\57\1\uffff\1\71\1\uffff\1\145"+
        "\2\uffff\2\172\1\163\1\162\1\156\1\154\1\124\1\162\1\165\1\164\20"+
        "\uffff\1\145\1\172\1\143\1\163\1\120\1\172\2\145\1\172\1\uffff\1"+
        "\164\1\145\1\125\1\uffff\2\172\1\uffff\1\151\1\172\1\124\2\uffff"+
        "\1\157\1\uffff\1\172\1\156\1\uffff\1\172\1\uffff";
    static final String DFA22_acceptS =
        "\10\uffff\1\13\1\uffff\1\15\1\16\1\17\1\20\1\21\1\22\3\uffff\1\31"+
        "\1\uffff\1\33\1\uffff\1\36\1\uffff\1\40\1\uffff\1\44\1\45\12\uffff"+
        "\1\23\1\14\1\24\1\35\1\25\1\26\1\30\1\27\1\32\1\42\1\43\1\34\1\37"+
        "\1\41\1\1\1\11\11\uffff\1\3\3\uffff\1\6\2\uffff\1\2\3\uffff\1\7"+
        "\1\12\1\uffff\1\10\2\uffff\1\5\1\uffff\1\4";
    static final String DFA22_specialS =
        "\124\uffff}>";
    static final String[] DFA22_transitionS = {
            "\2\33\2\uffff\1\33\22\uffff\1\33\1\20\1\34\3\uffff\1\17\1\uffff"+
            "\1\14\1\15\1\25\1\23\1\27\1\24\1\30\1\26\12\32\1\uffff\1\10"+
            "\1\21\1\11\1\22\2\uffff\16\31\1\4\13\31\4\uffff\1\31\1\uffff"+
            "\3\31\1\7\1\2\1\3\2\31\1\1\12\31\1\6\1\31\1\5\4\31\1\12\1\16"+
            "\1\13",
            "\1\35\7\uffff\1\36",
            "\1\37",
            "\1\42\15\uffff\1\40\5\uffff\1\41",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "",
            "\1\47",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\51",
            "\1\53",
            "\1\55",
            "",
            "\1\60\1\uffff\12\32",
            "",
            "\1\61\4\uffff\1\61",
            "",
            "\12\60",
            "",
            "\1\60\1\uffff\12\32\13\uffff\1\60\37\uffff\1\60",
            "",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
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
            "",
            "",
            "\1\77",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\101",
            "\1\102",
            "\1\103",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\105",
            "\1\106",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\1\110",
            "\1\111",
            "\1\112",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\1\115",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\117",
            "",
            "",
            "\1\120",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\122",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( IF | ELSE | FOR | FUNCTION | OUTPUT | VAR | TRUE | FALSE | IN | DATE | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | ID | INT | FLOAT | COMMENT | WS | STRING );";
        }
    }
 

}