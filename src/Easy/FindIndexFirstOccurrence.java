import static java.lang.System.out;


/**
 * <p>Given two <code>Strings</code>, <code>needle</code> and <code>haystack</code>, return the index of the
 * first occurrence of <code>needle</code> in <code>haystack</code>, or <code>-1</code> if <code>needle</code>
 * is not part of <code>haystack</code>.</p>
 *
 * <p>Constraints:
 * <ul>
 *     <li>1 &le haystack.length(), needle.length() &le 10^4</li>
 *     <li>`haystack` and `needle` consist of only lowercase English characters.</li>
 * </ul>
 */
public class FindIndexFirstOccurrence {

    /**
     * This approach uses a sliding window to solve the problem. The for loop iterates over <code>haystack</code>
     * and the index the for loop uses is the component of the sliding window that representsthe starting
     * point of comparisons, and thus also the return index for the first possible match of <code>needle</code>
     * in <code>haystack</code>.
     */
    public static int strStr(String haystack, String needle) {
        // Needle cannot be in haystack if needle is larger than the haystack
	if (needle.length() > haystack.length()) {
	    return -1;
	}
	// Iterate over haystack entirely
	for (int i = 0; i < haystack.length(); i++) {
	    int hPtr = i;          // Starting point for comparison in haystack; must be distinct from i
	    int nPtr = 0;          // Each iteration should start at front of needle
	    // Compare the characters in haystack and needle at their respective pointer locations
	    while (hPtr < haystack.length() && nPtr < needle.length()) {
		char h = haystack.charAt(hPtr);
		char n = needle.charAt(nPtr);
		if (h == n) {
		    hPtr++;
		    nPtr++;
		} else {
		    break;
		}
	    }
	    // nPtr will be the same length of needle IFF a match was found;
	    // WILL NOT WORK if you don't check if needle.length() > haystack.length() initially
	    if (nPtr == needle.length()) {
		return i;
	    }
	}
	// Iteration over haystack has completed and no matches were found
	return -1;
    }


    public static void main(String[] args) {
	String[] haystacks = {
	    "sadbutsad",
	    "leetcode",
	    "aa",
	    "aaa",
	    "mississippi",
	    "mississippi",
	    "mississippi"
	};
	String[] needles = {
	    "sad",
	    "leeto",
	    "a",
	    "aaaa",
	    "issip",
	    "issipi",
	    "pi",
	};
	int[] results = {0, -1, 0, -1, 4, -1, -1};

	for (int i = 0; i < results.length; i++) {
	    String h = haystacks[i];
	    String n = needles[i];
	    int r = results[i];
	    int a = strStr(h, n);
	    out.println("haystack:\t" + h);
	    out.println("needle:\t" + n);
	    out.println("result:\t" + r);
	    out.println("answer:\t" + a);
	    out.println("correct:\t" + a == r);
	}
    }
}
