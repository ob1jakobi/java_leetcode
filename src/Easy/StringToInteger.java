import java.lang.StringBuilder;
import static java.lang.System.out;


public class StringToInteger {

	public static int myAtoi(String s) {
		s = s.stripLeading();
		if (s.isEmpty()) {
			return 0;
		}
		int i = 0;
		int sign;
		int result = 0;
		switch (s.charAt(0))
		{
			case '+':
				sign = 1;
				i++;
				break;
			case '-':
				sign = -1;
				i++;
				break;
			default:
				sign = 1;
				break;
		}
		for (; i < s.length(); i++) {
			int digit;
			char c = s.charAt(i);
			if (!Character.isDigit(c)) {
				break;
			}
			digit = c - '0';
			boolean hasOverflowed =
					(result > Integer.MAX_VALUE / 10) ||
							(result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10);
			if (hasOverflowed) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + digit;
		}
		return sign * result;
	}

    /*
    public static int myAtoi(String s) {
		int sign = 1;
		int result = 0;
		int index = 0;
		int n = s.length();

		// Discard all spaces from the beginning of the input string.
		while (index < n && s.charAt(index) == ' ') {
			index++;
		}

		// sign = +1, if it's positive number, otherwise sign = -1.
		if (index < n && s.charAt(index) == '+') {
			sign = 1;
			index++;
		} else if (index < n && s.charAt(index) == '-') {
			sign = -1;
			index++;
		}

		// Traverse next digits of input and stop if it is not a digit
		while (index < n && Character.isDigit(s.charAt(index))) {
			int digit = s.charAt(index) - '0';

			// Check overflow and underflow conditions.
			if ((result > Integer.MAX_VALUE / 10) ||
					(result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
				// If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			// Append current digit to the result.
			result = 10 * result + digit;
			index++;
		}
		// We have formed a valid number without any overflow/underflow.
		// Return it after multiplying it with its sign.
		return sign * result;
	}
    */

    public static void main(String[] args) {
	String s1 = "52";
	String s2 = "         -52";
	String s3 = "2324 with words";
	String s4 = "";
	String s5 = " ";
	String s6 = "with words 134";
	String s7 = "-323 jkj;ea";
	String s8 = "0";
	String s9 = "-";
	String s10 = "+-1";
	String s11 = "+1";
	String s12 = "00000-42";
	String s13 = "00000-42a1234";
	String s14 = "  0000000  ";
	String s15 = "000003";
	String s16 = "2000000000000000000";
	String s17 = "-2000000000000000000";
	String s18 = "  0000000000012345678";
	String s19 = "-91283472332";

	String[] ss =
	    {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19};
	for (String s: ss) {
	    int result = myAtoi(s);
	    out.printf("s:\t%s\nr:\t%d\n\n", s, result);
	}
    }
}
