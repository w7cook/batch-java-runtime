// $ANTLR 3.4 /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g 2012-02-08 13:41:58

package batch.syntax;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

@SuppressWarnings({ "all", "warnings", "unchecked" })
public class BatchScriptParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "ALPHA", "COMMENT", "DATE", "DIGIT", "DO",
			"ELSE", "END", "ESC_SEQ", "EXPONENT", "FALSE", "FLOAT", "FOR", "FUN",
			"HEX_DIGIT", "ID", "IF", "IN", "INT", "OCTAL_ESC", "STRING", "THEN",
			"TRUE", "UNICODE_ESC", "VAR", "WS", "'!'", "'!='", "'&&'", "'&&='",
			"'('", "')'", "'*'", "'*='", "'+'", "'+='", "','", "'-'", "'-='", "'.'",
			"'/'", "':'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'||'",
			"'||='" };

	public static final int EOF = -1;
	public static final int T__29 = 29;
	public static final int T__30 = 30;
	public static final int T__31 = 31;
	public static final int T__32 = 32;
	public static final int T__33 = 33;
	public static final int T__34 = 34;
	public static final int T__35 = 35;
	public static final int T__36 = 36;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int T__39 = 39;
	public static final int T__40 = 40;
	public static final int T__41 = 41;
	public static final int T__42 = 42;
	public static final int T__43 = 43;
	public static final int T__44 = 44;
	public static final int T__45 = 45;
	public static final int T__46 = 46;
	public static final int T__47 = 47;
	public static final int T__48 = 48;
	public static final int T__49 = 49;
	public static final int T__50 = 50;
	public static final int T__51 = 51;
	public static final int T__52 = 52;
	public static final int T__53 = 53;
	public static final int ALPHA = 4;
	public static final int COMMENT = 5;
	public static final int DATE = 6;
	public static final int DIGIT = 7;
	public static final int DO = 8;
	public static final int ELSE = 9;
	public static final int END = 10;
	public static final int ESC_SEQ = 11;
	public static final int EXPONENT = 12;
	public static final int FALSE = 13;
	public static final int FLOAT = 14;
	public static final int FOR = 15;
	public static final int FUN = 16;
	public static final int HEX_DIGIT = 17;
	public static final int ID = 18;
	public static final int IF = 19;
	public static final int IN = 20;
	public static final int INT = 21;
	public static final int OCTAL_ESC = 22;
	public static final int STRING = 23;
	public static final int THEN = 24;
	public static final int TRUE = 25;
	public static final int UNICODE_ESC = 26;
	public static final int VAR = 27;
	public static final int WS = 28;

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

	public String[] getTokenNames() {
		return BatchScriptParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "/Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g";
	}

	Factory f = new batch.syntax.Factory();

	static public Expression parse(String script)
			throws org.antlr.runtime.RecognitionException {
		org.antlr.runtime.CharStream stream = new org.antlr.runtime.ANTLRStringStream(
				script);
		BatchScriptLexer lexer = new BatchScriptLexer(stream);
		BatchScriptParser parser = new BatchScriptParser(new CommonTokenStream(
				lexer));
		return parser.block();
	}

	// $ANTLR start "main"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:40:1:
	// main returns [Expression value] : e= block EOF ;
	public final Expression main() throws RecognitionException {
		Expression value = null;

		Expression e = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:41:2:
			// (e= block EOF )
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:41:4:
			// e= block EOF
			{
				pushFollow(FOLLOW_block_in_main141);
				e = block();

				state._fsp--;

				value = e;

				match(input, EOF, FOLLOW_EOF_in_main145);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "main"

	// $ANTLR start "block"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:44:1:
	// block returns [Expression value] : (e= statement ( ';' (es= block )? )? |
	// VAR x= ID '=' e= expr ';' b= block );
	public final Expression block() throws RecognitionException {
		Expression value = null;

		Token x = null;
		Expression e = null;

		Expression es = null;

		Expression b = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:45:2:
			// (e= statement ( ';' (es= block )? )? | VAR x= ID '=' e= expr ';' b=
			// block )
			int alt3 = 2;
			int LA3_0 = input.LA(1);

			if ((LA3_0 == DATE || (LA3_0 >= FALSE && LA3_0 <= FUN)
					|| (LA3_0 >= ID && LA3_0 <= IF) || LA3_0 == INT || LA3_0 == STRING
					|| LA3_0 == TRUE || LA3_0 == 29 || LA3_0 == 33)) {
				alt3 = 1;
			} else if ((LA3_0 == VAR)) {
				alt3 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0, input);

				throw nvae;

			}
			switch (alt3) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:45:4:
				// e= statement ( ';' (es= block )? )?
			{
				pushFollow(FOLLOW_statement_in_block162);
				e = statement();

				state._fsp--;

				value = e;

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:45:29:
				// ( ';' (es= block )? )?
				int alt2 = 2;
				int LA2_0 = input.LA(1);

				if ((LA2_0 == 45)) {
					alt2 = 1;
				}
				switch (alt2) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:45:30:
					// ';' (es= block )?
				{
					match(input, 45, FOLLOW_45_in_block167);

					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:45:34:
					// (es= block )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == DATE || (LA1_0 >= FALSE && LA1_0 <= FUN)
							|| (LA1_0 >= ID && LA1_0 <= IF) || LA1_0 == INT
							|| LA1_0 == STRING || LA1_0 == TRUE || LA1_0 == VAR
							|| LA1_0 == 29 || LA1_0 == 33)) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
						// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:45:35:
						// es= block
					{
						pushFollow(FOLLOW_block_in_block172);
						es = block();

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
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:46:4:
				// VAR x= ID '=' e= expr ';' b= block
			{
				match(input, VAR, FOLLOW_VAR_in_block183);

				x = (Token) match(input, ID, FOLLOW_ID_in_block187);

				match(input, 48, FOLLOW_48_in_block189);

				pushFollow(FOLLOW_expr_in_block193);
				e = expr();

				state._fsp--;

				match(input, 45, FOLLOW_45_in_block195);

				pushFollow(FOLLOW_block_in_block199);
				b = block();

				state._fsp--;

				value = f.Let(x.getText(), e, b);

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "block"

	// $ANTLR start "statement"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:49:1:
	// statement returns [Expression value] : ( FOR x= ID IN e= expr DO b= block
	// END |e= expr );
	public final Expression statement() throws RecognitionException {
		Expression value = null;

		Token x = null;
		Expression e = null;

		Expression b = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:50:2:
			// ( FOR x= ID IN e= expr DO b= block END |e= expr )
			int alt4 = 2;
			int LA4_0 = input.LA(1);

			if ((LA4_0 == FOR)) {
				alt4 = 1;
			} else if ((LA4_0 == DATE || (LA4_0 >= FALSE && LA4_0 <= FLOAT)
					|| LA4_0 == FUN || (LA4_0 >= ID && LA4_0 <= IF) || LA4_0 == INT
					|| LA4_0 == STRING || LA4_0 == TRUE || LA4_0 == 29 || LA4_0 == 33)) {
				alt4 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

				throw nvae;

			}
			switch (alt4) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:50:4:
				// FOR x= ID IN e= expr DO b= block END
			{
				match(input, FOR, FOLLOW_FOR_in_statement220);

				x = (Token) match(input, ID, FOLLOW_ID_in_statement224);

				match(input, IN, FOLLOW_IN_in_statement226);

				pushFollow(FOLLOW_expr_in_statement230);
				e = expr();

				state._fsp--;

				match(input, DO, FOLLOW_DO_in_statement232);

				pushFollow(FOLLOW_block_in_statement236);
				b = block();

				state._fsp--;

				match(input, END, FOLLOW_END_in_statement238);

				value = f.Loop(x.getText(), e, b);

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:51:4:
				// e= expr
			{
				pushFollow(FOLLOW_expr_in_statement248);
				e = expr();

				state._fsp--;

				value = e;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "statement"

	// $ANTLR start "expr"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:54:1:
	// expr returns [Expression value] : ( FUN '(' x= ID ')' e= block |e= or );
	public final Expression expr() throws RecognitionException {
		Expression value = null;

		Token x = null;
		Expression e = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:55:2:
			// ( FUN '(' x= ID ')' e= block |e= or )
			int alt5 = 2;
			int LA5_0 = input.LA(1);

			if ((LA5_0 == FUN)) {
				alt5 = 1;
			} else if ((LA5_0 == DATE || (LA5_0 >= FALSE && LA5_0 <= FLOAT)
					|| (LA5_0 >= ID && LA5_0 <= IF) || LA5_0 == INT || LA5_0 == STRING
					|| LA5_0 == TRUE || LA5_0 == 29 || LA5_0 == 33)) {
				alt5 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

				throw nvae;

			}
			switch (alt5) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:55:4:
				// FUN '(' x= ID ')' e= block
			{
				match(input, FUN, FOLLOW_FUN_in_expr265);

				match(input, 33, FOLLOW_33_in_expr267);

				x = (Token) match(input, ID, FOLLOW_ID_in_expr271);

				match(input, 34, FOLLOW_34_in_expr273);

				pushFollow(FOLLOW_block_in_expr277);
				e = block();

				state._fsp--;

				value = f.Fun(x.getText(), e);

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:56:4:
				// e= or
			{
				pushFollow(FOLLOW_or_in_expr290);
				e = or();

				state._fsp--;

				value = e;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "expr"

	// $ANTLR start "or"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:59:1:
	// or returns [Expression value] : a= and ( '||' b= or )? ;
	public final Expression or() throws RecognitionException {
		Expression value = null;

		Expression a = null;

		Expression b = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:60:2:
			// (a= and ( '||' b= or )? )
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:60:4:
			// a= and ( '||' b= or )?
			{
				pushFollow(FOLLOW_and_in_or311);
				a = and();

				state._fsp--;

				value = a;

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:60:21:
				// ( '||' b= or )?
				int alt6 = 2;
				int LA6_0 = input.LA(1);

				if ((LA6_0 == 52)) {
					alt6 = 1;
				}
				switch (alt6) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:60:22:
					// '||' b= or
				{
					match(input, 52, FOLLOW_52_in_or316);

					pushFollow(FOLLOW_or_in_or320);
					b = or();

					state._fsp--;

					value = f.Prim(batch.Op.OR, a, b);

				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "or"

	// $ANTLR start "and"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:62:1:
	// and returns [Expression value] : a= not ( '&&' b= and )? ;
	public final Expression and() throws RecognitionException {
		Expression value = null;

		Expression a = null;

		Expression b = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:63:2:
			// (a= not ( '&&' b= and )? )
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:63:4:
			// a= not ( '&&' b= and )?
			{
				pushFollow(FOLLOW_not_in_and340);
				a = not();

				state._fsp--;

				value = a;

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:63:21:
				// ( '&&' b= and )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);

				if ((LA7_0 == 31)) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:63:22:
					// '&&' b= and
				{
					match(input, 31, FOLLOW_31_in_and345);

					pushFollow(FOLLOW_and_in_and349);
					b = and();

					state._fsp--;

					value = f.Prim(batch.Op.AND, a, b);

				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "and"

	// $ANTLR start "not"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:65:1:
	// not returns [Expression value] : ( '!' e= not |e= comp );
	public final Expression not() throws RecognitionException {
		Expression value = null;

		Expression e = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:66:2:
			// ( '!' e= not |e= comp )
			int alt8 = 2;
			int LA8_0 = input.LA(1);

			if ((LA8_0 == 29)) {
				alt8 = 1;
			} else if ((LA8_0 == DATE || (LA8_0 >= FALSE && LA8_0 <= FLOAT)
					|| (LA8_0 >= ID && LA8_0 <= IF) || LA8_0 == INT || LA8_0 == STRING
					|| LA8_0 == TRUE || LA8_0 == 33)) {
				alt8 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 8, 0, input);

				throw nvae;

			}
			switch (alt8) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:66:4:
				// '!' e= not
			{
				match(input, 29, FOLLOW_29_in_not369);

				pushFollow(FOLLOW_not_in_not373);
				e = not();

				state._fsp--;

				value = f.Prim(batch.Op.NOT, e);

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:67:4:
				// e= comp
			{
				pushFollow(FOLLOW_comp_in_not382);
				e = comp();

				state._fsp--;

				value = e;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "not"

	// $ANTLR start "comp"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:70:1:
	// comp returns [Expression value] : a= term (op= compop b= comp )? ;
	public final Expression comp() throws RecognitionException {
		Expression value = null;

		Expression a = null;

		batch.Op op = null;

		Expression b = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:71:2:
			// (a= term (op= compop b= comp )? )
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:71:4:
			// a= term (op= compop b= comp )?
			{
				pushFollow(FOLLOW_term_in_comp401);
				a = term();

				state._fsp--;

				value = a;

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:71:22:
				// (op= compop b= comp )?
				int alt9 = 2;
				switch (input.LA(1)) {
				case 49: {
					alt9 = 1;
				}
					break;
				case 30: {
					alt9 = 1;
				}
					break;
				case 47: {
					alt9 = 1;
				}
					break;
				case 46: {
					alt9 = 1;
				}
					break;
				case 50: {
					alt9 = 1;
				}
					break;
				case 51: {
					alt9 = 1;
				}
					break;
				}

				switch (alt9) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:71:23:
					// op= compop b= comp
				{
					pushFollow(FOLLOW_compop_in_comp408);
					op = compop();

					state._fsp--;

					pushFollow(FOLLOW_comp_in_comp412);
					b = comp();

					state._fsp--;

					value = f.Prim(op, a, b);

				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "comp"

	// $ANTLR start "compop"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:73:1:
	// compop returns [batch.Op op] : ( '==' | '!=' | '<=' | '<' | '>' | '>=' );
	public final batch.Op compop() throws RecognitionException {
		batch.Op op = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:74:3:
			// ( '==' | '!=' | '<=' | '<' | '>' | '>=' )
			int alt10 = 6;
			switch (input.LA(1)) {
			case 49: {
				alt10 = 1;
			}
				break;
			case 30: {
				alt10 = 2;
			}
				break;
			case 47: {
				alt10 = 3;
			}
				break;
			case 46: {
				alt10 = 4;
			}
				break;
			case 50: {
				alt10 = 5;
			}
				break;
			case 51: {
				alt10 = 6;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 10, 0, input);

				throw nvae;

			}

			switch (alt10) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:74:5:
				// '=='
			{
				match(input, 49, FOLLOW_49_in_compop431);

				op = batch.Op.EQ;

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:75:5:
				// '!='
			{
				match(input, 30, FOLLOW_30_in_compop439);

				op = batch.Op.NE;

			}
				break;
			case 3:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:76:5:
				// '<='
			{
				match(input, 47, FOLLOW_47_in_compop447);

				op = batch.Op.LE;

			}
				break;
			case 4:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:77:5:
				// '<'
			{
				match(input, 46, FOLLOW_46_in_compop456);

				op = batch.Op.LT;

			}
				break;
			case 5:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:78:5:
				// '>'
			{
				match(input, 50, FOLLOW_50_in_compop465);

				op = batch.Op.GT;

			}
				break;
			case 6:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:79:5:
				// '>='
			{
				match(input, 51, FOLLOW_51_in_compop474);

				op = batch.Op.GE;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return op;
	}

	// $ANTLR end "compop"

	// $ANTLR start "term"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:82:1:
	// term returns [Expression value] : a= factor (op= addop b= term )? ;
	public final Expression term() throws RecognitionException {
		Expression value = null;

		Expression a = null;

		batch.Op op = null;

		Expression b = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:83:2:
			// (a= factor (op= addop b= term )? )
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:83:4:
			// a= factor (op= addop b= term )?
			{
				pushFollow(FOLLOW_factor_in_term494);
				a = factor();

				state._fsp--;

				value = a;

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:83:24:
				// (op= addop b= term )?
				int alt11 = 2;
				int LA11_0 = input.LA(1);

				if ((LA11_0 == 37)) {
					alt11 = 1;
				} else if ((LA11_0 == 40)) {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:83:25:
					// op= addop b= term
				{
					pushFollow(FOLLOW_addop_in_term501);
					op = addop();

					state._fsp--;

					pushFollow(FOLLOW_term_in_term505);
					b = term();

					state._fsp--;

					value = f.Prim(op, a, b);

				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "term"

	// $ANTLR start "addop"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:85:1:
	// addop returns [batch.Op op] : ( '+' | '-' );
	public final batch.Op addop() throws RecognitionException {
		batch.Op op = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:86:3:
			// ( '+' | '-' )
			int alt12 = 2;
			int LA12_0 = input.LA(1);

			if ((LA12_0 == 37)) {
				alt12 = 1;
			} else if ((LA12_0 == 40)) {
				alt12 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 12, 0, input);

				throw nvae;

			}
			switch (alt12) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:86:5:
				// '+'
			{
				match(input, 37, FOLLOW_37_in_addop526);

				op = batch.Op.ADD;

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:87:5:
				// '-'
			{
				match(input, 40, FOLLOW_40_in_addop534);

				op = batch.Op.SUB;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return op;
	}

	// $ANTLR end "addop"

	// $ANTLR start "factor"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:90:1:
	// factor returns [Expression value] : a= base (op= mulop b= factor )? ;
	public final Expression factor() throws RecognitionException {
		Expression value = null;

		Expression a = null;

		batch.Op op = null;

		Expression b = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:91:2:
			// (a= base (op= mulop b= factor )? )
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:91:4:
			// a= base (op= mulop b= factor )?
			{
				pushFollow(FOLLOW_base_in_factor554);
				a = base();

				state._fsp--;

				value = a;

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:91:22:
				// (op= mulop b= factor )?
				int alt13 = 2;
				int LA13_0 = input.LA(1);

				if ((LA13_0 == 35)) {
					alt13 = 1;
				} else if ((LA13_0 == 43)) {
					alt13 = 1;
				}
				switch (alt13) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:91:23:
					// op= mulop b= factor
				{
					pushFollow(FOLLOW_mulop_in_factor561);
					op = mulop();

					state._fsp--;

					pushFollow(FOLLOW_factor_in_factor565);
					b = factor();

					state._fsp--;

					value = f.Prim(op, a, b);

				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "factor"

	// $ANTLR start "mulop"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:93:1:
	// mulop returns [batch.Op op] : ( '*' | '/' );
	public final batch.Op mulop() throws RecognitionException {
		batch.Op op = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:94:3:
			// ( '*' | '/' )
			int alt14 = 2;
			int LA14_0 = input.LA(1);

			if ((LA14_0 == 35)) {
				alt14 = 1;
			} else if ((LA14_0 == 43)) {
				alt14 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 14, 0, input);

				throw nvae;

			}
			switch (alt14) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:94:5:
				// '*'
			{
				match(input, 35, FOLLOW_35_in_mulop584);

				op = batch.Op.MUL;

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:95:5:
				// '/'
			{
				match(input, 43, FOLLOW_43_in_mulop592);

				op = batch.Op.DIV;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return op;
	}

	// $ANTLR end "mulop"

	// $ANTLR start "base"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:98:1:
	// base returns [Expression value] : (e= assign | IF a= expr THEN t= block (
	// ELSE e= block )? END |x= INT |x= STRING | DATE '(' x= STRING ')' |x= FLOAT
	// |x= TRUE |x= FALSE | '(' e= block ')' );
	public final Expression base() throws RecognitionException {
		Expression value = null;

		Token x = null;
		Expression e = null;

		Expression a = null;

		Expression t = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:99:2:
			// (e= assign | IF a= expr THEN t= block ( ELSE e= block )? END |x= INT
			// |x= STRING | DATE '(' x= STRING ')' |x= FLOAT |x= TRUE |x= FALSE | '('
			// e= block ')' )
			int alt16 = 9;
			switch (input.LA(1)) {
			case ID: {
				alt16 = 1;
			}
				break;
			case IF: {
				alt16 = 2;
			}
				break;
			case INT: {
				alt16 = 3;
			}
				break;
			case STRING: {
				alt16 = 4;
			}
				break;
			case DATE: {
				alt16 = 5;
			}
				break;
			case FLOAT: {
				alt16 = 6;
			}
				break;
			case TRUE: {
				alt16 = 7;
			}
				break;
			case FALSE: {
				alt16 = 8;
			}
				break;
			case 33: {
				alt16 = 9;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 16, 0, input);

				throw nvae;

			}

			switch (alt16) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:99:4:
				// e= assign
			{
				pushFollow(FOLLOW_assign_in_base613);
				e = assign();

				state._fsp--;

				value = e;

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:100:4:
				// IF a= expr THEN t= block ( ELSE e= block )? END
			{
				match(input, IF, FOLLOW_IF_in_base621);

				pushFollow(FOLLOW_expr_in_base625);
				a = expr();

				state._fsp--;

				match(input, THEN, FOLLOW_THEN_in_base627);

				pushFollow(FOLLOW_block_in_base631);
				t = block();

				state._fsp--;

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:100:27:
				// ( ELSE e= block )?
				int alt15 = 2;
				int LA15_0 = input.LA(1);

				if ((LA15_0 == ELSE)) {
					alt15 = 1;
				}
				switch (alt15) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:100:28:
					// ELSE e= block
				{
					match(input, ELSE, FOLLOW_ELSE_in_base634);

					pushFollow(FOLLOW_block_in_base638);
					e = block();

					state._fsp--;

				}
					break;

				}

				match(input, END, FOLLOW_END_in_base642);

				value = f.If(a, t, e);

			}
				break;
			case 3:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:101:4:
				// x= INT
			{
				x = (Token) match(input, INT, FOLLOW_INT_in_base652);

				value = f.Data(Integer.parseInt(x.getText()));

			}
				break;
			case 4:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:102:4:
				// x= STRING
			{
				x = (Token) match(input, STRING, FOLLOW_STRING_in_base661);

				String str = x.getText();
				str = str.substring(1, str.length() - 1);
				str = str.replace("\\\"", "\"");
				str = str.replace("\\\\", "\\");
				value = f.Data(str);

			}
				break;
			case 5:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:108:4:
				// DATE '(' x= STRING ')'
			{
				match(input, DATE, FOLLOW_DATE_in_base668);

				match(input, 33, FOLLOW_33_in_base670);

				x = (Token) match(input, STRING, FOLLOW_STRING_in_base674);

				match(input, 34, FOLLOW_34_in_base676);

				String str = x.getText();
				str = str.substring(1, str.length() - 1);
				value = f.Data(java.sql.Date.valueOf(str));

			}
				break;
			case 6:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:113:4:
				// x= FLOAT
			{
				x = (Token) match(input, FLOAT, FOLLOW_FLOAT_in_base685);

				value = f.Data(Float.parseFloat(x.getText()));

			}
				break;
			case 7:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:114:4:
				// x= TRUE
			{
				x = (Token) match(input, TRUE, FOLLOW_TRUE_in_base694);

				value = f.Data(true);

			}
				break;
			case 8:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:115:4:
				// x= FALSE
			{
				x = (Token) match(input, FALSE, FOLLOW_FALSE_in_base703);

				value = f.Data(false);

			}
				break;
			case 9:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:116:4:
				// '(' e= block ')'
			{
				match(input, 33, FOLLOW_33_in_base709);

				pushFollow(FOLLOW_block_in_base713);
				e = block();

				state._fsp--;

				match(input, 34, FOLLOW_34_in_base715);

				value = e;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "base"

	// $ANTLR start "assign"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:119:1:
	// assign returns [Expression value] : a= prim (op= assignop b= expr )? ;
	public final Expression assign() throws RecognitionException {
		Expression value = null;

		Expression a = null;

		batch.Op op = null;

		Expression b = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:120:3:
			// (a= prim (op= assignop b= expr )? )
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:120:6:
			// a= prim (op= assignop b= expr )?
			{
				pushFollow(FOLLOW_prim_in_assign736);
				a = prim();

				state._fsp--;

				value = a;

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:120:24:
				// (op= assignop b= expr )?
				int alt17 = 2;
				switch (input.LA(1)) {
				case 48: {
					alt17 = 1;
				}
					break;
				case 38: {
					alt17 = 1;
				}
					break;
				case 41: {
					alt17 = 1;
				}
					break;
				case 36: {
					alt17 = 1;
				}
					break;
				case 53: {
					alt17 = 1;
				}
					break;
				case 32: {
					alt17 = 1;
				}
					break;
				}

				switch (alt17) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:120:25:
					// op= assignop b= expr
				{
					pushFollow(FOLLOW_assignop_in_assign743);
					op = assignop();

					state._fsp--;

					pushFollow(FOLLOW_expr_in_assign747);
					b = expr();

					state._fsp--;

					value = f.Assign(op, a, b);

				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "assign"

	// $ANTLR start "assignop"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:122:1:
	// assignop returns [batch.Op op] : ( '=' | '+=' | '-=' | '*=' | '||=' | '&&='
	// );
	public final batch.Op assignop() throws RecognitionException {
		batch.Op op = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:123:3:
			// ( '=' | '+=' | '-=' | '*=' | '||=' | '&&=' )
			int alt18 = 6;
			switch (input.LA(1)) {
			case 48: {
				alt18 = 1;
			}
				break;
			case 38: {
				alt18 = 2;
			}
				break;
			case 41: {
				alt18 = 3;
			}
				break;
			case 36: {
				alt18 = 4;
			}
				break;
			case 53: {
				alt18 = 5;
			}
				break;
			case 32: {
				alt18 = 6;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 18, 0, input);

				throw nvae;

			}

			switch (alt18) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:123:5:
				// '='
			{
				match(input, 48, FOLLOW_48_in_assignop767);

				op = batch.Op.SEQ;

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:124:5:
				// '+='
			{
				match(input, 38, FOLLOW_38_in_assignop775);

				op = batch.Op.ADD;

			}
				break;
			case 3:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:125:5:
				// '-='
			{
				match(input, 41, FOLLOW_41_in_assignop783);

				op = batch.Op.SUB;

			}
				break;
			case 4:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:126:5:
				// '*='
			{
				match(input, 36, FOLLOW_36_in_assignop792);

				op = batch.Op.MUL;

			}
				break;
			case 5:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:127:5:
				// '||='
			{
				match(input, 53, FOLLOW_53_in_assignop801);

				op = batch.Op.OR;

			}
				break;
			case 6:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:128:5:
				// '&&='
			{
				match(input, 32, FOLLOW_32_in_assignop810);

				op = batch.Op.AND;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return op;
	}

	// $ANTLR end "assignop"

	// $ANTLR start "prim"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:131:1:
	// prim returns [Expression value] : b= ID ( ':' e= expr |r= access[value] ) ;
	public final Expression prim() throws RecognitionException {
		Expression value = null;

		Token b = null;
		Expression e = null;

		Expression r = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:132:3:
			// (b= ID ( ':' e= expr |r= access[value] ) )
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:132:5:
			// b= ID ( ':' e= expr |r= access[value] )
			{
				b = (Token) match(input, ID, FOLLOW_ID_in_prim834);

				value = f.Var(b.getText());

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:133:5:
				// ( ':' e= expr |r= access[value] )
				int alt19 = 2;
				int LA19_0 = input.LA(1);

				if ((LA19_0 == 44)) {
					alt19 = 1;
				} else if ((LA19_0 == EOF || (LA19_0 >= DO && LA19_0 <= END)
						|| LA19_0 == THEN || (LA19_0 >= 30 && LA19_0 <= 32)
						|| (LA19_0 >= 34 && LA19_0 <= 43) || (LA19_0 >= 45 && LA19_0 <= 53))) {
					alt19 = 2;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 19, 0, input);

					throw nvae;

				}
				switch (alt19) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:133:7:
					// ':' e= expr
				{
					match(input, 44, FOLLOW_44_in_prim844);

					pushFollow(FOLLOW_expr_in_prim848);
					e = expr();

					state._fsp--;

					value = f.Out(b.getText(), e);

				}
					break;
				case 2:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:134:8:
					// r= access[value]
				{
					pushFollow(FOLLOW_access_in_prim862);
					r = access(value);

					state._fsp--;

					value = r;

				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "prim"

	// $ANTLR start "access"
	// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:139:1:
	// access[Expression base] returns [Expression value] : ( '.' x= ID ( '(' (e=
	// expr ( ',' e= expr )* )? ')' )? r= access[value] |);
	public final Expression access(Expression base) throws RecognitionException {
		Expression value = null;

		Token x = null;
		Expression e = null;

		Expression r = null;

		try {
			// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:140:2:
			// ( '.' x= ID ( '(' (e= expr ( ',' e= expr )* )? ')' )? r= access[value]
			// |)
			int alt23 = 2;
			int LA23_0 = input.LA(1);

			if ((LA23_0 == 42)) {
				alt23 = 1;
			} else if ((LA23_0 == EOF || (LA23_0 >= DO && LA23_0 <= END)
					|| LA23_0 == THEN || (LA23_0 >= 30 && LA23_0 <= 32)
					|| (LA23_0 >= 34 && LA23_0 <= 41) || LA23_0 == 43 || (LA23_0 >= 45 && LA23_0 <= 53))) {
				alt23 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 23, 0, input);

				throw nvae;

			}
			switch (alt23) {
			case 1:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:140:4:
				// '.' x= ID ( '(' (e= expr ( ',' e= expr )* )? ')' )? r= access[value]
			{
				match(input, 42, FOLLOW_42_in_access889);

				x = (Token) match(input, ID, FOLLOW_ID_in_access893);

				value = f.Prop(base, x.getText());

				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:141:6:
				// ( '(' (e= expr ( ',' e= expr )* )? ')' )?
				int alt22 = 2;
				int LA22_0 = input.LA(1);

				if ((LA22_0 == 33)) {
					alt22 = 1;
				}
				switch (alt22) {
				case 1:
					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:141:8:
					// '(' (e= expr ( ',' e= expr )* )? ')'
				{
					match(input, 33, FOLLOW_33_in_access905);

					List<Expression> args = new ArrayList();

					// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:142:4:
					// (e= expr ( ',' e= expr )* )?
					int alt21 = 2;
					int LA21_0 = input.LA(1);

					if ((LA21_0 == DATE || (LA21_0 >= FALSE && LA21_0 <= FLOAT)
							|| LA21_0 == FUN || (LA21_0 >= ID && LA21_0 <= IF)
							|| LA21_0 == INT || LA21_0 == STRING || LA21_0 == TRUE
							|| LA21_0 == 29 || LA21_0 == 33)) {
						alt21 = 1;
					}
					switch (alt21) {
					case 1:
						// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:142:6:
						// e= expr ( ',' e= expr )*
					{
						pushFollow(FOLLOW_expr_in_access916);
						e = expr();

						state._fsp--;

						args.add(e);

						// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:143:6:
						// ( ',' e= expr )*
						loop20: do {
							int alt20 = 2;
							int LA20_0 = input.LA(1);

							if ((LA20_0 == 39)) {
								alt20 = 1;
							}

							switch (alt20) {
							case 1:
								// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:143:7:
								// ',' e= expr
							{
								match(input, 39, FOLLOW_39_in_access926);

								pushFollow(FOLLOW_expr_in_access930);
								e = expr();

								state._fsp--;

								args.add(e);

							}
								break;

							default:
								break loop20;
							}
						} while (true);

					}
						break;

					}

					match(input, 34, FOLLOW_34_in_access948);

					value = f.Call(base, x.getText(), args);

				}
					break;

				}

				pushFollow(FOLLOW_access_in_access967);
				r = access(value);

				state._fsp--;

				value = r;

			}
				break;
			case 2:
				// /Users/wcook/workspace/batches/runtime/src/main/java/batch/syntax/BatchScript.g:148:5:
			{
				value = base;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "access"

	// Delegated rules

	public static final BitSet FOLLOW_block_in_main141 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_main145 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_statement_in_block162 = new BitSet(
			new long[] { 0x0000200000000002L });
	public static final BitSet FOLLOW_45_in_block167 = new BitSet(
			new long[] { 0x000000022AADE042L });
	public static final BitSet FOLLOW_block_in_block172 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_VAR_in_block183 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_ID_in_block187 = new BitSet(
			new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_48_in_block189 = new BitSet(
			new long[] { 0x0000000222AD6040L });
	public static final BitSet FOLLOW_expr_in_block193 = new BitSet(
			new long[] { 0x0000200000000000L });
	public static final BitSet FOLLOW_45_in_block195 = new BitSet(
			new long[] { 0x000000022AADE040L });
	public static final BitSet FOLLOW_block_in_block199 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FOR_in_statement220 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_ID_in_statement224 = new BitSet(
			new long[] { 0x0000000000100000L });
	public static final BitSet FOLLOW_IN_in_statement226 = new BitSet(
			new long[] { 0x0000000222AD6040L });
	public static final BitSet FOLLOW_expr_in_statement230 = new BitSet(
			new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_DO_in_statement232 = new BitSet(
			new long[] { 0x000000022AADE040L });
	public static final BitSet FOLLOW_block_in_statement236 = new BitSet(
			new long[] { 0x0000000000000400L });
	public static final BitSet FOLLOW_END_in_statement238 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expr_in_statement248 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FUN_in_expr265 = new BitSet(
			new long[] { 0x0000000200000000L });
	public static final BitSet FOLLOW_33_in_expr267 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_ID_in_expr271 = new BitSet(
			new long[] { 0x0000000400000000L });
	public static final BitSet FOLLOW_34_in_expr273 = new BitSet(
			new long[] { 0x000000022AADE040L });
	public static final BitSet FOLLOW_block_in_expr277 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_or_in_expr290 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_and_in_or311 = new BitSet(
			new long[] { 0x0010000000000002L });
	public static final BitSet FOLLOW_52_in_or316 = new BitSet(
			new long[] { 0x0000000222AC6040L });
	public static final BitSet FOLLOW_or_in_or320 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_not_in_and340 = new BitSet(
			new long[] { 0x0000000080000002L });
	public static final BitSet FOLLOW_31_in_and345 = new BitSet(
			new long[] { 0x0000000222AC6040L });
	public static final BitSet FOLLOW_and_in_and349 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_29_in_not369 = new BitSet(
			new long[] { 0x0000000222AC6040L });
	public static final BitSet FOLLOW_not_in_not373 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_comp_in_not382 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_term_in_comp401 = new BitSet(
			new long[] { 0x000EC00040000002L });
	public static final BitSet FOLLOW_compop_in_comp408 = new BitSet(
			new long[] { 0x0000000202AC6040L });
	public static final BitSet FOLLOW_comp_in_comp412 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_49_in_compop431 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_30_in_compop439 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_47_in_compop447 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_46_in_compop456 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_50_in_compop465 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_51_in_compop474 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_factor_in_term494 = new BitSet(
			new long[] { 0x0000012000000002L });
	public static final BitSet FOLLOW_addop_in_term501 = new BitSet(
			new long[] { 0x0000000202AC6040L });
	public static final BitSet FOLLOW_term_in_term505 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_37_in_addop526 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_40_in_addop534 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_base_in_factor554 = new BitSet(
			new long[] { 0x0000080800000002L });
	public static final BitSet FOLLOW_mulop_in_factor561 = new BitSet(
			new long[] { 0x0000000202AC6040L });
	public static final BitSet FOLLOW_factor_in_factor565 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_35_in_mulop584 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_43_in_mulop592 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_assign_in_base613 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IF_in_base621 = new BitSet(
			new long[] { 0x0000000222AD6040L });
	public static final BitSet FOLLOW_expr_in_base625 = new BitSet(
			new long[] { 0x0000000001000000L });
	public static final BitSet FOLLOW_THEN_in_base627 = new BitSet(
			new long[] { 0x000000022AADE040L });
	public static final BitSet FOLLOW_block_in_base631 = new BitSet(
			new long[] { 0x0000000000000600L });
	public static final BitSet FOLLOW_ELSE_in_base634 = new BitSet(
			new long[] { 0x000000022AADE040L });
	public static final BitSet FOLLOW_block_in_base638 = new BitSet(
			new long[] { 0x0000000000000400L });
	public static final BitSet FOLLOW_END_in_base642 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INT_in_base652 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_STRING_in_base661 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DATE_in_base668 = new BitSet(
			new long[] { 0x0000000200000000L });
	public static final BitSet FOLLOW_33_in_base670 = new BitSet(
			new long[] { 0x0000000000800000L });
	public static final BitSet FOLLOW_STRING_in_base674 = new BitSet(
			new long[] { 0x0000000400000000L });
	public static final BitSet FOLLOW_34_in_base676 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FLOAT_in_base685 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TRUE_in_base694 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FALSE_in_base703 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_33_in_base709 = new BitSet(
			new long[] { 0x000000022AADE040L });
	public static final BitSet FOLLOW_block_in_base713 = new BitSet(
			new long[] { 0x0000000400000000L });
	public static final BitSet FOLLOW_34_in_base715 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_prim_in_assign736 = new BitSet(
			new long[] { 0x0021025100000002L });
	public static final BitSet FOLLOW_assignop_in_assign743 = new BitSet(
			new long[] { 0x0000000222AD6040L });
	public static final BitSet FOLLOW_expr_in_assign747 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_48_in_assignop767 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_38_in_assignop775 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_41_in_assignop783 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_36_in_assignop792 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_53_in_assignop801 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_32_in_assignop810 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ID_in_prim834 = new BitSet(
			new long[] { 0x0000140000000000L });
	public static final BitSet FOLLOW_44_in_prim844 = new BitSet(
			new long[] { 0x0000000222AD6040L });
	public static final BitSet FOLLOW_expr_in_prim848 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_access_in_prim862 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_42_in_access889 = new BitSet(
			new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_ID_in_access893 = new BitSet(
			new long[] { 0x0000040200000000L });
	public static final BitSet FOLLOW_33_in_access905 = new BitSet(
			new long[] { 0x0000000622AD6040L });
	public static final BitSet FOLLOW_expr_in_access916 = new BitSet(
			new long[] { 0x0000008400000000L });
	public static final BitSet FOLLOW_39_in_access926 = new BitSet(
			new long[] { 0x0000000222AD6040L });
	public static final BitSet FOLLOW_expr_in_access930 = new BitSet(
			new long[] { 0x0000008400000000L });
	public static final BitSet FOLLOW_34_in_access948 = new BitSet(
			new long[] { 0x0000040000000000L });
	public static final BitSet FOLLOW_access_in_access967 = new BitSet(
			new long[] { 0x0000000000000002L });

}