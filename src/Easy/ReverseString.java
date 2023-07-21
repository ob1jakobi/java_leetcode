import static java.lang.System.out;
import java.util.Arrays;

/**
 * <p>Write a function that reverses a <code>String</code>. The input is given as an array of characters,
 * <code>s</code>. You must do this by modifying the input array in-place with <code>O(1)</code>
 * extra memory.</p>
 *
 * Constraints:
 * <ul>
 *    <li>1 &le s.length &le 10^5</li>
 *    <li>`s[i]` is a printable ascii character.</li>
 * </ul>
 */
public class ReverseString {

    /**
     * This implementation uses a two-pointer approach, where you bring both the left and right-most
     * pointers together, swapping each of their respective characters using a temporary variable,
     * until the left pointer &ge the right pointer.
     */
    public static void reverseString(char[] s) {
	for (int l = 0, r = s.length - 1; l < r; l++, r--) {
	    char lChar = s[l];
	    s[l] = s[r];
	    s[r] = lChar;
	}

	/* same as above, but distinct 2-pointer method
	int l = 0;
	int r = s.length - 1;
	while (l < r) {
	    char lChar = s[l];
	    s[l++] = s[r];
	    s[r--] = lChar;
	}
	*/
    }


    public static void main(String[] args) {
	char[] s1 = {'h', 'e', 'l', 'l', 'o'};
	char[] s2 = {'h', 'a', 'n', 'n', 'a', 'h'};
	char[] s3 = {'h', 'i'};
	char[] s4 = {'a'};
	char[] s5 = {'f', 'a', 'r'};
	char[] s6 = {'f', 'a', 'r', 't'};

	char[][] allS = {s1, s2, s3, s4, s5, s6};
	for (char[] s: allS) {
	    char[] newS = Arrays.copyOf(s, s.length);
	    reverseString(newS);
	    out.printf("oldS:\t%s\nnewS:\t%s\n\n",
		       Arrays.toString(s),
		       Arrays.toString(newS));
	}
    }
}
