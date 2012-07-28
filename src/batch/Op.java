// Written by William Cook, Ben Wiedermann, Ali Ibrahim
// The University of Texas at Austin, Department of Computer Science
// See LICENSE.txt for license information
package batch;

/*
	
-	ABS() 	Return the absolute value
?	ACOS() 	Return the arc cosine
-	ADDDATE()(v4.1.1) 	Add time values (intervals) to a date value
-	ADDTIME()(v4.1.1) 	Add time
-	AES_DECRYPT() 	Decrypt using AES
-	AES_ENCRYPT() 	Encrypt using AES
*	AND, && 	Logical AND
-	ASCII() 	Return numeric value of left-most character
?	ASIN() 	Return the arc sine
?	ATAN2(), ATAN() 	Return the arc tangent of the two arguments
?	ATAN() 	Return the arc tangent
-	AVG() 	Return the average value of the argument
-	BENCHMARK() 	Repeatedly execute an exp
?	BETWEEN ... AND ... 	Check whether a value is within a range of values
?	BIN() 	Return a string representation of the argument
?	BINARY 	Cast a string to a binary string
?	BIT_AND() 	Return bitwise and
?	BIT_COUNT() 	Return the number of bits that are set
?	BIT_LENGTH() 	Return length of argument in bits
?	BIT_OR() 	Return bitwise or
?	BIT_XOR()(v4.1.1) 	Return bitwise xor
*	CASE 	Case operator
-	CAST() 	Cast a value as a certain type
-	CEIL() 	Return the smallest integer value not less than the argument
-	CHAR_LENGTH() 	Return number of characters in argument
-	CHAR() 	Return the character for each integer passed
?	 CHARSET()(v4.1.0) 	Return the character set of the argument
-	COALESCE() 	Return the first non-NULL argument
?	COERCIBILITY()(v4.1.1) 	Return the collation coercibility value of the string argument
?	COLLATION()(v4.1.0) 	Return the collation of the string argument
?	COMPRESS()(v4.1.1) 	Return result as a binary string
-	CONCAT_WS() 	Return concatenate with separator
-	CONCAT() 	Return concatenated string
?	CONNECTION_ID() 	Return the connection ID (thread ID) for the connection
-	CONV() 	Convert numbers between different number bases
-	CONVERT_TZ()(v4.1.3) 	Convert from one timezone to another
-	Convert() 	Cast a value as a certain type
?	COS() 	Return the cosine
?	COT() 	Return the cotangent
-	COUNT(DISTINCT) 	Return the count of a number of different values
*	COUNT() 	Return a count of the number of rows returned
-	CRC32()(v4.1.0) 	Compute a cyclic redundancy check value
-	CURDATE() 	Return the current date
-	CURRENT_USER(), CURRENT_USER 	The authenticated user name and host name
-	CURTIME() 	Return the current time
-	DATABASE() 	Return the default (current) database name
-	DATE_ADD() 	Add time values (intervals) to a date value
	DATE_FORMAT() 	Format date as specified
	DATE_SUB() 	Subtract two dates
	DATE()(v4.1.1) 	Extract the date part of a date or datetime exp
	DATEDIFF()(v4.1.1) 	Subtract two dates
	DAYNAME()(v4.1.21) 	Return the name of the weekday
	DAYOFMONTH() 	Return the day of the month (0-31)
	DAYOFWEEK() 	Return the weekday index of the argument
	DAYOFYEAR() 	Return the day of the year (1-366)
	DECODE() 	Decodes a string encrypted using ENCODE()
	DEFAULT() 	Return the default value for a table column
	DEGREES() 	Convert radians to degrees
	DES_DECRYPT() 	Decrypt a string
	DES_ENCRYPT() 	Encrypt a string
	DIV(v4.1.0) 	Integer division
	/ 	Division operator
	ELT() 	Return string at index number
	ENCODE() 	Encode a string
	ENCRYPT() 	Encrypt a string
	<=> 	NULL-safe equal to operator
	= 	Equal operator
	EXP() 	Raise to the power of
	EXPORT_SET() 	Return a string such that for every bit set in the value bits, you get an on string and for every unset bit, you get an off string
	EXTRACT 	Extract part of a date
	FIELD() 	Return the index (position) of the first argument in the subsequent arguments
	FIND_IN_SET() 	Return the index position of the first argument within the second argument
	FLOOR() 	Return the largest integer value not greater than the argument
	FORMAT() 	Return a number formatted to specified number of decimal places
	FOUND_ROWS() 	For a SELECT with a LIMIT clause, the number of rows that would be returned were there no LIMIT clause
	FROM_DAYS() 	Convert a day number to a date
	FROM_UNIXTIME() 	Format UNIX timestamp as a date
	GET_FORMAT()(v4.1.1) 	Return a date format string
	GET_LOCK() 	Get a named lock
	>= 	Greater than or equal operator
	> 	Greater than operator
	GREATEST() 	Return the largest argument
	GROUP_CONCAT()(v4.1) 	Return a concatenated string
	HEX() 	Return a hexadecimal representation of a decimal or string value
	HOUR() 	Extract the hour
	IF() 	If/else construct
	IFNULL() 	Null if/else construct
	IN() 	Check whether a value is within a set of values
	INET_ATON() 	Return the numeric value of an IP address
	INET_NTOA() 	Return the IP address from a numeric value
	INSERT() 	Insert a substring at the specified position up to the specified number of characters
	INSTR() 	Return the index of the first occurrence of substring
	INTERVAL() 	Return the index of the argument that is less than the first argument
	IS_FREE_LOCK() 	Checks whether the named lock is free
	IS_USED_LOCK()(v4.1.0) 	Checks whether the named lock is in use. Return connection identifier if true.
	IS 	Test a value against a boolean
	ISNULL() 	Test whether the argument is NULL
	LAST_DAY(v4.1.1) 	Return the last day of the month for the argument
	LAST_INSERT_ID() 	Value of the AUTOINCREMENT column for the last INSERT
	LEAST() 	Return the smallest argument
?	<< 	Left shift
	LEFT() 	Return the leftmost number of characters as specified
	LENGTH() 	Return the length of a string in bytes
	<= 	Less than or equal operator
	< 	Less than operator
	LIKE 	Simple pattern matching
	LN() 	Return the natural logarithm of the argument
	LOAD_FILE() 	Load the named file
	LOCATE() 	Return the position of the first occurrence of substring
-	LOG10() 	Return the base-10 logarithm of the argument
-	LOG2() 	Return the base-2 logarithm of the argument
-	LOG() 	Return the natural logarithm of the first argument
	LOWER() 	Return the argument in lowercase
	LPAD() 	Return the string argument, left-padded with the specified string
	LTRIM() 	Remove leading spaces
	MAKE_SET() 	Return a set of comma-separated strings that have the corresponding bit in bits set
	MAKEDATE()(v4.1.1) 	Create a date from the year and day of year
	MAKETIME(v4.1.1) 	MAKETIME()
	MASTER_POS_WAIT() 	Block until the slave has read and applied all updates up to the specified position
	MATCH 	Perform full-text search
	MAX() 	Return the maximum value
	MD5() 	Calculate MD5 checksum
	MICROSECOND()(v4.1.1) 	Return the microseconds from argument
	MID() 	Return a substring starting from the specified position
*	MIN() 	Return the minimum value
	- 	Minus operator
	MINUTE() 	Return the minute from the argument
-	% 	Modulo operator
	MONTH() 	Return the month from the date passed
	MONTHNAME()(v4.1.21) 	Return the name of the month
	NAME_CONST()(v5.0.12) 	Causes the column to have the given name
	NOT BETWEEN ... AND ... 	Check whether a value is not within a range of values
	!=, <> 	Not equal operator
	NOT IN() 	Check whether a value is not within a set of values
	NOT LIKE 	Negation of simple pattern matching
	NOT REGEXP 	Negation of REGEXP
	NOT, ! 	Negates value
	NOW() 	Return the current date and time
?	NULLIF() 	Return NULL if expr1 = expr2
?	OCT() 	Return an octal representation of a decimal number
	OLD_PASSWORD()(v4.1) 	Return the value of the old (pre-4.1) implementation of PASSWORD
	||, OR 	Logical OR
	ORD() 	Return character code for leftmost character of the argument
	PASSWORD() 	Calculate and return a password string
	PERIOD_ADD() 	Add a period to a year-month
	PERIOD_DIFF() 	Return the number of months between periods
	PI() 	Return the value of pi
	+ 	Addition operator
?	POW() 	Return the argument raised to the specified power
	PROCEDURE ANALYSE() 	Analyze the results of a query
	QUARTER() 	Return the quarter from a date argument
	QUOTE() 	Escape the argument for use in an SQL statement
	RADIANS() 	Return argument converted to radians
	RAND() 	Return a random floating-point value
	REGEXP 	Pattern matching using regular expressions
	RELEASE_LOCK() 	Releases the named lock
	REPEAT() 	Repeat a string the specified number of times
	REPLACE() 	Replace occurrences of a specified string
	REVERSE() 	Reverse the characters in a string
	>> 	Right shift
	RIGHT() 	Return the specified rightmost number of characters
	ROUND() 	Round the argument
	ROW_COUNT()(v5.0.1) 	The number of rows updated
	RPAD() 	Append string the specified number of times
	RTRIM() 	Remove trailing spaces
	SEC_TO_TIME() 	Converts seconds to 'HH:MM:SS' format
	SECOND() 	Return the second (0-59)
	SHA1(), SHA() 	Calculate an SHA-1 160-bit checksum
	SIGN() 	Return the sign of the argument
	SIN() 	Return the sine of the argument
	SLEEP()(v5.0.12) 	Sleep for a number of seconds
	SOUNDEX() 	Return a soundex string
	SOUNDS LIKE(v4.1.0) 	Compare sounds
	SPACE() 	Return a string of the specified number of spaces
	SQRT() 	Return the square root of the argument
	STD() 	Return the population standard deviation
	STDDEV_POP()(v5.0.3) 	Return the population standard deviation
	STDDEV_SAMP()(v5.0.3) 	Return the sample standard deviation
	STDDEV() 	Return the population standard deviation
	STR_TO_DATE()(v4.1.1) 	Convert a string to a date
	STRCMP() 	Compare two strings
	SUBSTR() 	Return the substring as specified
	SUBSTRING_INDEX() 	Return a substring from a string before the specified number of occurrences of the delimiter
	SUBSTRING() 	Return the substring as specified
	SUBTIME()(v4.1.1) 	Subtract times
	SUM() 	Return the sum
	SYSDATE() 	Return the time at which the function executes
	TAN() 	Return the tangent of the argument
	TIME_FORMAT() 	Format as time
	TIME_TO_SEC() 	Return the argument converted to seconds
	TIME()(v4.1.1) 	Extract the time portion of the exp passed
	TIMEDIFF()(v4.1.1) 	Subtract time
	* 	Times operator
	TIMESTAMP()(v4.1.1) 	With a single argument, this function returns the date or datetime exp; with two arguments, the sum of the arguments
	TIMESTAMPADD()(v5.0.0) 	Add an interval to a datetime exp
	TIMESTAMPDIFF()(v5.0.0) 	Subtract an interval from a datetime exp
	TO_DAYS() 	Return the date argument converted to days
	TRIM() 	Remove leading and trailing spaces
	TRUNCATE() 	Truncate to specified number of decimal places
	- 	Change the sign of the argument
	UNCOMPRESS()(v4.1.1) 	Uncompress a string compressed
	UNCOMPRESSED_LENGTH()(v4.1.1) 	Return the length of a string before compression
	UNHEX()(v4.1.2) 	Convert each pair of hexadecimal digits to a character
	UNIX_TIMESTAMP() 	Return a UNIX timestamp
	UPPER() 	Convert to uppercase
	USER() 	The user name and host name provided by the client
	UTC_DATE()(v4.1.1) 	Return the current UTC date
	UTC_TIME()(v4.1.1) 	Return the current UTC time
	UTC_TIMESTAMP()(v4.1.1) 	Return the current UTC date and time
	UUID()(v4.1.2) 	Return a Universal Unique Identifier (UUID)
	VALUES()(v4.1.1) 	Defines the values to be used during an INSERT
	VAR_POP()(v5.0.3) 	Return the population standard variance
	VAR_SAMP()(v5.0.3) 	Return the sample variance
	VARIANCE()(v4.1) 	Return the population standard variance
	VERSION() 	Returns a string that indicates the MySQL server version
	WEEK() 	Return the week number
	WEEKDAY() 	Return the weekday index
	WEEKOFYEAR()(v4.1.1) 	Return the calendar week of the date (0-53)
	XOR 	Logical XOR
	YEAR() 	Return the year
	YEARWEEK() 	Return the year and week

 */
public enum Op {
	ADD, SUB, MUL, DIV, MOD, // arithmetic
	NE, EQ, LT, GT, LE, GE, // comparison
	AND, OR, NOT, // logical
	AVG, MIN, MAX, COUNT, // aggregation
	SEQ, // empty sequence is SKIP
	ASC, DESC, // sorting
	GROUP; // mapping and grouping

	public boolean unary() {
		return this == ADD || this == SUB || this == DIV || this == NOT;
	}

	public int exactCount() {
		switch (this) {
		case NOT:
			return 1;
		case EQ:
			return 2;
		case NE:
			return 2;
		case LT:
			return 2;
		case GT:
			return 2;
		case LE:
			return 2;
		case GE:
			return 2;
		}
		return -1;
	}

	public String getOpSymbol() {
		switch (this) {
		case ADD:
			return "+";
		case SUB:
			return "-";
		case MUL:
			return "*";
		case DIV:
			return "/";
		case MOD:
			return "%";
		case AVG:
			return "AVG";
		case MIN:
			return "MIN";
		case MAX:
			return "MAX";
		case COUNT:
			return "COUNT";
		case AND:
			return "&&";
		case OR:
			return "||";
		case NOT:
			return "!";
		case EQ:
			return "==";
		case NE:
			return "!=";
		case LT:
			return "<";
		case GT:
			return ">";
		case LE:
			return "<=";
		case GE:
			return ">=";
		case SEQ:
			return ";";
		}
		return null;
	}
	
	public String getAggSymbol() {
		switch (this) {
		case ADD:
			return "sum";
		case MUL:
			return "product";
		case AVG:
			return "average";
		case MIN:
			return "min";
		case MAX:
			return "max";
		case COUNT:
			return "count";
		case AND:
			return "all";
		case OR:
			return "any";
		case SEQ:
			return "";
		}
		return null;
	}

	static public Op lookupAggOp(String name) {
		if (name == null) return SEQ;
		if (name.equals("sum")) return ADD;
		if (name.equals("product")) return MUL;
		if (name.equals("average")) return AVG;
		if (name.equals("min")) return MIN;
		if (name.equals("max")) return MAX;
		if (name.equals("count")) return COUNT;
		if (name.equals("all")) return AND;
		if (name.equals("any")) return OR;
		return null;
	}

	public boolean isBoolean() {
		switch (this) {
		case AND:
		case OR:
		case NOT:
		case EQ:
		case NE:
		case LT:
		case GT:
		case LE:
		case GE:
			return true;
		}
		return false;
	}


}
