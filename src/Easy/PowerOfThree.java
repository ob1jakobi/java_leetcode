import java.util.Random;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 * Given an integer <code>n</code>, return <code>true</code> <em>if it is a power of three,
 * otherwise return <code>false</code></em>. An integer <code>n</code> is a power of three if
 * there exists an integer <code>x</code> such that <code>n == 3<sup>x</sup></code>.
 *
 * Constraints:
 * <ul>
 *    <li>-2^32 &le n &le 2^31 - 1</li>
 * </ul>
 */
public class PowerOfThree {

    /**
     * To determine if <code>n</code> is a power of 3, repeatedly compute the powers of 3 starting from 0,
     * and ending when the computed power of 3 is &le <code>n</code>. If <code>n</code> is negative, then
     * there will be no power of 3 that exists to obtain the negative value. Because this uses a <code>while
     * </code> loop, the run time would be O(log n).
     */
    public static boolean isPowerOfThree(int n) {
	int power;
	double powOf3;

	power = 0;
	do {
	    powOf3 = Math.pow(3, power++);
	} while (powOf3 < n);
	return Double.compare(powOf3, (double) n) == 0;
    }

    public static void main(String[] args) {
	Random r = new Random();
        ArrayList<Integer> ns = new ArrayList<>();
	ns.add(1);
	for (int i = 0; i < 21; i++) {
	    int num;
	    if (i % 2 == 0) {
		num = (int) Math.pow(3, i);
		num = i % 3 == 0 ? num * -1 : num;
	    } else {
		num = r.nextInt();
	    }
	    ns.add(num);
	}
	for (int n: ns) {
	    out.printf("n:\t%d\nr:\t%b\n\n", n, isPowerOfThree(n));
	}
    }
}
