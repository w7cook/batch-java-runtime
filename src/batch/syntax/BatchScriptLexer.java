// $ANTLR 3.4 /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g 2012-02-08 13:41:58

package batch.syntax;


import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class BatchScriptLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int ALPHA=4;
    public static final int COMMENT=5;
    public static final int DATE=6;
    public static final int DIGIT=7;
    public static final int DO=8;
    public static final int ELSE=9;
    public static final int END=10;
    public static final int ESC_SEQ=11;
    public static final int EXPONENT=12;
    public static final int FALSE=13;
    public static final int FLOAT=14;
    public static final int FOR=15;
    public static final int FUN=16;
    public static final int HEX_DIGIT=17;
    public static final int ID=18;
    public static final int IF=19;
    public static final int IN=20;
    public static final int INT=21;
    public static final int OCTAL_ESC=22;
    public static final int STRING=23;
    public static final int THEN=24;
    public static final int TRUE=25;
    public static final int UNICODE_ESC=26;
    public static final int VAR=27;
    public static final int WS=28;

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
    public String getGrammarFileName() { return "/Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g"; }

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:6:6: ( 'date' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:6:8: 'date'
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

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:7:4: ( 'do' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:7:6: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:8:6: ( 'else' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:8:8: 'else'
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

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:9:5: ( 'end' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:9:7: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:10:7: ( 'false' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:10:9: 'false'
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:11:5: ( 'for' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:11:7: 'for'
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

    // $ANTLR start "FUN"
    public final void mFUN() throws RecognitionException {
        try {
            int _type = FUN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:12:5: ( 'fun' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:12:7: 'fun'
            {
            match("fun"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUN"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:13:4: ( 'if' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:13:6: 'if'
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:14:4: ( 'in' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:14:6: 'in'
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

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:15:6: ( 'then' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:15:8: 'then'
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:16:6: ( 'true' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:16:8: 'true'
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:17:5: ( 'var' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:17:7: 'var'
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

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:18:7: ( '!' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:18:9: '!'
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:19:7: ( '!=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:19:9: '!='
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:20:7: ( '&&' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:20:9: '&&'
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:21:7: ( '&&=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:21:9: '&&='
            {
            match("&&="); 



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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:22:7: ( '(' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:22:9: '('
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:23:7: ( ')' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:23:9: ')'
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:24:7: ( '*' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:24:9: '*'
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:25:7: ( '*=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:25:9: '*='
            {
            match("*="); 



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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:26:7: ( '+' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:26:9: '+'
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:27:7: ( '+=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:27:9: '+='
            {
            match("+="); 



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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:28:7: ( ',' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:28:9: ','
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
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:29:7: ( '-' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:29:9: '-'
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
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:30:7: ( '-=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:30:9: '-='
            {
            match("-="); 



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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:31:7: ( '.' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:31:9: '.'
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
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:32:7: ( '/' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:32:9: '/'
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
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:33:7: ( ':' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:33:9: ':'
            {
            match(':'); 

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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:34:7: ( ';' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:34:9: ';'
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
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:35:7: ( '<' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:35:9: '<'
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
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:36:7: ( '<=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:36:9: '<='
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
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:37:7: ( '=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:37:9: '='
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
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:38:7: ( '==' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:38:9: '=='
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
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:39:7: ( '>' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:39:9: '>'
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
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:40:7: ( '>=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:40:9: '>='
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
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:41:7: ( '||' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:41:9: '||'
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
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:42:7: ( '||=' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:42:9: '||='
            {
            match("||="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:152:16: ( '0' .. '9' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:153:16: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:155:5: ( ALPHA ( ALPHA | DIGIT )* )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:155:7: ALPHA ( ALPHA | DIGIT )*
            {
            mALPHA(); 


            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:155:13: ( ALPHA | DIGIT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:158:5: ( ( '-' )? ( DIGIT )+ )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:158:7: ( '-' )? ( DIGIT )+
            {
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:158:7: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:158:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:158:12: ( DIGIT )+
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
            	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:162:5: ( ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )? | ( '-' )? '.' ( DIGIT )+ ( EXPONENT )? | ( '-' )? ( DIGIT )+ EXPONENT )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:162:9: ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )?
                    {
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:162:9: ( '-' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='-') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:162:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:162:14: ( DIGIT )+
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
                    	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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

                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:162:25: ( DIGIT )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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


                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:162:32: ( EXPONENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='E'||LA7_0=='e') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:162:32: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:163:9: ( '-' )? '.' ( DIGIT )+ ( EXPONENT )?
                    {
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:163:9: ( '-' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='-') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:163:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    match('.'); 

                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:163:18: ( DIGIT )+
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
                    	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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


                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:163:25: ( EXPONENT )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:163:25: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:164:9: ( '-' )? ( DIGIT )+ EXPONENT
                    {
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:164:9: ( '-' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='-') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:164:9: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:164:14: ( DIGIT )+
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
                    	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:168:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
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
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:168:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:168:14: (~ ( '\\n' | '\\r' ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0 >= '\u0000' && LA14_0 <= '\t')||(LA14_0 >= '\u000B' && LA14_0 <= '\f')||(LA14_0 >= '\u000E' && LA14_0 <= '\uFFFF')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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


                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:168:28: ( '\\r' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='\r') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:168:28: '\\r'
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
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:169:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:169:14: ( options {greedy=false; } : . )*
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
                    	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:169:42: .
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
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:172:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:172:9: ( ' ' | '\\t' | '\\r' | '\\n' )
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:180:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:180:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:180:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\\') ) {
                    alt18=1;
                }
                else if ( ((LA18_0 >= '\u0000' && LA18_0 <= '!')||(LA18_0 >= '#' && LA18_0 <= '[')||(LA18_0 >= ']' && LA18_0 <= '\uFFFF')) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:180:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:180:24: ~ ( '\\\\' | '\"' )
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
            	    break loop18;
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

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:185:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:185:12: ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:185:22: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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


            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:185:33: ( DIGIT )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:188:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:
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

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:192:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt21=1;
                    }
                    break;
                case 'u':
                    {
                    alt21=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt21=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:192:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:193:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:194:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:199:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\\') ) {
                int LA22_1 = input.LA(2);

                if ( ((LA22_1 >= '0' && LA22_1 <= '3')) ) {
                    int LA22_2 = input.LA(3);

                    if ( ((LA22_2 >= '0' && LA22_2 <= '7')) ) {
                        int LA22_4 = input.LA(4);

                        if ( ((LA22_4 >= '0' && LA22_4 <= '7')) ) {
                            alt22=1;
                        }
                        else {
                            alt22=2;
                        }
                    }
                    else {
                        alt22=3;
                    }
                }
                else if ( ((LA22_1 >= '4' && LA22_1 <= '7')) ) {
                    int LA22_3 = input.LA(3);

                    if ( ((LA22_3 >= '0' && LA22_3 <= '7')) ) {
                        alt22=2;
                    }
                    else {
                        alt22=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:199:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
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
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:200:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:201:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
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

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:206:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:206:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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

    public void mTokens() throws RecognitionException {
        // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:8: ( DATE | DO | ELSE | END | FALSE | FOR | FUN | IF | IN | THEN | TRUE | VAR | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | ID | INT | FLOAT | COMMENT | WS | STRING )
        int alt23=43;
        alt23 = dfa23.predict(input);
        switch (alt23) {
            case 1 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:10: DATE
                {
                mDATE(); 


                }
                break;
            case 2 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:15: DO
                {
                mDO(); 


                }
                break;
            case 3 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:18: ELSE
                {
                mELSE(); 


                }
                break;
            case 4 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:23: END
                {
                mEND(); 


                }
                break;
            case 5 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:27: FALSE
                {
                mFALSE(); 


                }
                break;
            case 6 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:33: FOR
                {
                mFOR(); 


                }
                break;
            case 7 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:37: FUN
                {
                mFUN(); 


                }
                break;
            case 8 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:41: IF
                {
                mIF(); 


                }
                break;
            case 9 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:44: IN
                {
                mIN(); 


                }
                break;
            case 10 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:47: THEN
                {
                mTHEN(); 


                }
                break;
            case 11 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:52: TRUE
                {
                mTRUE(); 


                }
                break;
            case 12 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:57: VAR
                {
                mVAR(); 


                }
                break;
            case 13 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:61: T__29
                {
                mT__29(); 


                }
                break;
            case 14 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:67: T__30
                {
                mT__30(); 


                }
                break;
            case 15 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:73: T__31
                {
                mT__31(); 


                }
                break;
            case 16 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:79: T__32
                {
                mT__32(); 


                }
                break;
            case 17 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:85: T__33
                {
                mT__33(); 


                }
                break;
            case 18 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:91: T__34
                {
                mT__34(); 


                }
                break;
            case 19 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:97: T__35
                {
                mT__35(); 


                }
                break;
            case 20 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:103: T__36
                {
                mT__36(); 


                }
                break;
            case 21 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:109: T__37
                {
                mT__37(); 


                }
                break;
            case 22 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:115: T__38
                {
                mT__38(); 


                }
                break;
            case 23 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:121: T__39
                {
                mT__39(); 


                }
                break;
            case 24 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:127: T__40
                {
                mT__40(); 


                }
                break;
            case 25 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:133: T__41
                {
                mT__41(); 


                }
                break;
            case 26 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:139: T__42
                {
                mT__42(); 


                }
                break;
            case 27 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:145: T__43
                {
                mT__43(); 


                }
                break;
            case 28 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:151: T__44
                {
                mT__44(); 


                }
                break;
            case 29 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:157: T__45
                {
                mT__45(); 


                }
                break;
            case 30 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:163: T__46
                {
                mT__46(); 


                }
                break;
            case 31 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:169: T__47
                {
                mT__47(); 


                }
                break;
            case 32 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:175: T__48
                {
                mT__48(); 


                }
                break;
            case 33 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:181: T__49
                {
                mT__49(); 


                }
                break;
            case 34 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:187: T__50
                {
                mT__50(); 


                }
                break;
            case 35 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:193: T__51
                {
                mT__51(); 


                }
                break;
            case 36 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:199: T__52
                {
                mT__52(); 


                }
                break;
            case 37 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:205: T__53
                {
                mT__53(); 


                }
                break;
            case 38 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:211: ID
                {
                mID(); 


                }
                break;
            case 39 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:214: INT
                {
                mINT(); 


                }
                break;
            case 40 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:218: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 41 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:224: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 42 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:232: WS
                {
                mWS(); 


                }
                break;
            case 43 :
                // /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:1:235: STRING
                {
                mSTRING(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA23 dfa23 = new DFA23(this);
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
            return "161:1: FLOAT : ( ( '-' )? ( DIGIT )+ '.' ( DIGIT )* ( EXPONENT )? | ( '-' )? '.' ( DIGIT )+ ( EXPONENT )? | ( '-' )? ( DIGIT )+ EXPONENT );";
        }
    }
    static final String DFA23_eotS =
        "\1\uffff\6\27\1\50\3\uffff\1\53\1\55\1\uffff\1\57\1\61\1\63\2\uffff"+
        "\1\65\1\67\1\71\2\uffff\1\73\2\uffff\1\27\1\75\5\27\1\103\1\104"+
        "\3\27\2\uffff\1\111\20\uffff\1\113\1\uffff\1\27\1\uffff\1\27\1\116"+
        "\1\27\1\120\1\121\2\uffff\2\27\1\124\4\uffff\1\125\1\126\1\uffff"+
        "\1\27\2\uffff\1\130\1\131\3\uffff\1\132\3\uffff";
    static final String DFA23_eofS =
        "\133\uffff";
    static final String DFA23_minS =
        "\1\11\1\141\1\154\1\141\1\146\1\150\1\141\1\75\1\46\2\uffff\2\75"+
        "\1\uffff\1\56\1\60\1\52\2\uffff\3\75\1\174\1\uffff\1\56\2\uffff"+
        "\1\164\1\60\1\163\1\144\1\154\1\162\1\156\2\60\1\145\1\165\1\162"+
        "\2\uffff\1\75\20\uffff\1\75\1\uffff\1\145\1\uffff\1\145\1\60\1\163"+
        "\2\60\2\uffff\1\156\1\145\1\60\4\uffff\2\60\1\uffff\1\145\2\uffff"+
        "\2\60\3\uffff\1\60\3\uffff";
    static final String DFA23_maxS =
        "\1\174\1\157\1\156\1\165\1\156\1\162\1\141\1\75\1\46\2\uffff\2\75"+
        "\1\uffff\1\75\1\71\1\57\2\uffff\3\75\1\174\1\uffff\1\145\2\uffff"+
        "\1\164\1\172\1\163\1\144\1\154\1\162\1\156\2\172\1\145\1\165\1\162"+
        "\2\uffff\1\75\20\uffff\1\75\1\uffff\1\145\1\uffff\1\145\1\172\1"+
        "\163\2\172\2\uffff\1\156\1\145\1\172\4\uffff\2\172\1\uffff\1\145"+
        "\2\uffff\2\172\3\uffff\1\172\3\uffff";
    static final String DFA23_acceptS =
        "\11\uffff\1\21\1\22\2\uffff\1\27\3\uffff\1\34\1\35\4\uffff\1\46"+
        "\1\uffff\1\52\1\53\14\uffff\1\16\1\15\1\uffff\1\24\1\23\1\26\1\25"+
        "\1\31\1\30\1\50\1\32\1\51\1\33\1\37\1\36\1\41\1\40\1\43\1\42\1\uffff"+
        "\1\47\1\uffff\1\2\5\uffff\1\10\1\11\3\uffff\1\20\1\17\1\45\1\44"+
        "\2\uffff\1\4\1\uffff\1\6\1\7\2\uffff\1\14\1\1\1\3\1\uffff\1\12\1"+
        "\13\1\5";
    static final String DFA23_specialS =
        "\133\uffff}>";
    static final String[] DFA23_transitionS = {
            "\2\31\2\uffff\1\31\22\uffff\1\31\1\7\1\32\3\uffff\1\10\1\uffff"+
            "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\12\30\1\21\1\22\1\23"+
            "\1\24\1\25\2\uffff\32\27\4\uffff\1\27\1\uffff\3\27\1\1\1\2\1"+
            "\3\2\27\1\4\12\27\1\5\1\27\1\6\4\27\1\uffff\1\26",
            "\1\33\15\uffff\1\34",
            "\1\35\1\uffff\1\36",
            "\1\37\15\uffff\1\40\5\uffff\1\41",
            "\1\42\7\uffff\1\43",
            "\1\44\11\uffff\1\45",
            "\1\46",
            "\1\47",
            "\1\51",
            "",
            "",
            "\1\52",
            "\1\54",
            "",
            "\1\60\1\uffff\12\30\3\uffff\1\56",
            "\12\60",
            "\1\62\4\uffff\1\62",
            "",
            "",
            "\1\64",
            "\1\66",
            "\1\70",
            "\1\72",
            "",
            "\1\60\1\uffff\12\30\13\uffff\1\60\37\uffff\1\60",
            "",
            "",
            "\1\74",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\105",
            "\1\106",
            "\1\107",
            "",
            "",
            "\1\110",
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
            "\1\112",
            "",
            "\1\114",
            "",
            "\1\115",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\117",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "\1\122",
            "\1\123",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\1\127",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( DATE | DO | ELSE | END | FALSE | FOR | FUN | IF | IN | THEN | TRUE | VAR | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | ID | INT | FLOAT | COMMENT | WS | STRING );";
        }
    }
 

}