import java.util.Stack;
import java.lang.StringBuilder;


/**
 * <p>Write a function to find the longest common prefix <code>String</code> amongst an array of
 * <code>Strings</code>. If there is no common prefix, return an empty <code>String</code>.</p>
 *
 * <p>Constraints:
 * <ul>
 *    <li>1 &le strs.length &le 200</li>
 *    <li>0 <= strs[i].length() &le 200</li>
 *    <li>strs[i] consists of only lowercase English letters</li>
 * </ul></p>
 */
public class LongestCommonPrefix {

    public static String LongestCommonPrefix(String[] strs) {
	// Declare StringBuilder for holding the result
        StringBuilder sb;
	// Find out the length of the smallest String in strs - that's the largest the prefix can
	// possibly be.
	int n = Integer.MAX_VALUE;
	for (String s: strs) {
	    n = Math.min(n, s.length());
	}
	// If the smallest String is empty, then there is no valid prefix
	if (n == 0) {
	    return "";
	}
	// Initialize the StringBuilder with the first String in strs
	sb = new StringBuilder(strs[0]);
	// Iterate over all the Strings in strs
	for (int i = 1; i < strs.length; i++) {
	    String s = strs[i];
	    int sPtr = 0;
	    int sbPtr = 0;
	    // Compare each character in the iterated String to the characters in sb; break when different
	    while (sPtr < n && sbPtr < sb.length()) {
		char sChar = s.charAt(sPtr);
		char sbChar = sb.charAt(sbPtr);
		if (sChar == sbChar) {
		    sPtr++;
		    sbPtr++;
		} else {
		    break;
		}
	    }
	    // If there's a difference, then sb will be truncated (or stay the same)
	    sb = sb.delete(sbPtr, sb.length());
	}
	// Return the final value prefix as the String held in out StringBuilder
	return sb.toStrin();
    }


    public static void main(String[] args) {
	String[] strs1 = {"flower", "flow", "flight"};
	String[] strs2 = {"dog", "racecar", "car"};
	String[] strs3 = {"", "cat", "catherine"};
	String[] strs4 = {"catherine", "cat", ""};
	String[] strs5 = {"catherine", "", "cat"};
	String[] strs6 = {"mississippi","mis","mi"};
	String[] strs7 = {"mississippi","mississipp","missis"};
	String[] strs8 = {"a","apache","apartment"};
	String[] strs9 = {"ape","apache","apartment"};
	String[][] allStrs = {strs1, strs2, strs3, strs4, strs5, strs6, strs7, strs8, strs9};
	
	String[] results = {"fl", "", "", "", "", "mi", "missis", "a", "ap"};

	
    }
}
