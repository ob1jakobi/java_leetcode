import static java.lang.System.out;
import java.util.HashMap;


/**
 * <p>Given a <code>String, s</code> <em>find the first non-repeating character in it
 * and return its index</em>. If it does not exist, return <code>-1</code>.</p>
 *
 * Constraints:
 * <ul>
 *    <li>1 &le s.length &le 10^5</li>
 *    <li>`s` consists of only lowercase English letters</li>
 *</ul>
 */
public class FirstUniqueCharacterInAString {

    static String s1 = "leetcode";
    static String s2 = "loveleetcode";
    static String s3 = "aabb";
    static String s4 = "mississippi";
    static String s5 = "a";
    static String s6 = "ab";
    static String s7 = "abb";
    static String s8 = "aab";
    static String s9 = "supercalifragilisticexpialidocious";
    static String[] allS = {s1, s2, s3, s4, s5, s6, s7, s8, s9};

    public static int firstUniqueChar(String s) {
        HashMap<Character, Integer> lCounts = new HashMap<>();
	for (char c: s.toCharArray()) {
	    lCounts.merge(c, 1, Integer::sum);
	}
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    int count = lCounts.get(c);
	    if (count == 1) {
		return i;
	    }
	}
	return -1;
	
	/* works but isn't very efficient
        char[] arr = s.toCharArray();
	int l, r;
        for (char c: arr) {
	    l = 0;
	    r = arr.length - 1;
	    while (l < r) {
		char lChar = arr[l];
		char rChar = arr[r];
	        while (lChar != c) {
		    lChar = arr[++l];
		}
		while (rChar != c) {
		    rChar = arr[--r];
		}
	        break;
	    }
	    if (l == r) {
		return l;
	    }
	}
	return -1;
	*/
    }

    public static void main(String[] args) {
	for (String s: allS) {
	    out.printf("s:\t%s\nans:\t%d\n\n", s, firstUniqueChar(s));
	}
    }
}
