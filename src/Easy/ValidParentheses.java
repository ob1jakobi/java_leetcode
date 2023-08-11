import java.util.Stack;
import java.util.Random;
import java.lang.StringBuilder;


/**
 * Give a <code>String s</code> containing the characters <code>'(', ')', '{', '}', '[', ']'</code>,
 * determine if the input string is valid.<br>
 * An input string is valid if:
 * <ul>
 *    <li>Open brackets must be closed by the same type of brackets.</li>
 *    <li>Open brackets must be closed in the correct order.</li>
 *    <li>Every close bracket has a corresponding open bracket of the same type.</li>
 * </ul>
 *
 * Constraints:
 * <ul>
 *    <li>1 &le s.length() &le 10^4</li>
 *    <li>`s` consists of parentheses only `()[]{}`.</li>
 * </ul>
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
	Stack<Character> stack = new Stack<>();
	for (char c: s.toCharArray()) {
	    switch (c) {
	    case '[':
	    case '(':
	    case '{':
		stack.push(c);
		break;
	    default:
		if (!stack.isEmpty()) {
		    char d = stack.pop();
		    if (d == '(' && c == ')') {
			break;
		    } else if (d == '[' && c == ']') {
			break;
		    } else if (d == '{' && c == '}') {
			break;
		    }
		}
		return false;
	    }
	}
	return stack.isEmpty();  // Must ensure it's empty in case s == "(()"
    }

    /**
     * DOES NOT WORK - This will only work if <code>s</code> is symmetrical: ({[]}), but will fail if
     * <code>s</code> is asymmetrical: (){}[].
     */ 
    public static boolean isValidAlt(String s) {
	int l, r;
	char lChar, rChar;
	if (s.length() % 2 != 0) {    // s Can't pair properly if odd
	    return false;
	}

	l = (s.length() / 2) - 1;
	r = l + 1;
	for (; l >= 0 && r < s.length(); l--, r++) {
	    lChar = s.charAt(l);
	    rChar = s.charAt(r);

	    switch (lChar) {
	    case '[':
		if (rChar == ']') {
		    break;
		}
	    case '(':
		if (rChar == ')') {
		    break;
		}
	    case '[':
		if (rChar == ']') {
		    break;
		}
	    default:
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	StringBuilder sb;
	char[] parens = {'{', '}', '(', ')', '[', ']'};
	Random r = new Random();
	
	for (int i = 0; i < 10; i++) {
	    int n = i % 2 == 0 ? r.nextInt((int) Math.pow(10, 4)) : i;
	    sb = new StringBuilder();
	    for (int j = 0; j < n; j++) {
		char p = parens[r.nextInt(parens.length)];
		sb.append(p);
	    }
	    System.out.printf("s:\t%s\nr:\t%b\n\n", sb.toString(), isValid(sb.toString()));
	}
    }
}
