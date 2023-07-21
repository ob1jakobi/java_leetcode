import java.lang.StringBuilder;
import static java.lang.System.out;
import java.util.Arrays;

/**
 * <p>Give a signed 32-bit integer, <code>x</code>, return <code>x</code> <em>with its digits
 * reversed</em>. If reversing <code>x</code> causes the value to go outside the signed
 * 32-bit range <code>[-2<sup>32</sup>, 2<sup>32</sup> - 1]</code>, then return
 * <code>0</code>.</p>
 *
 * <p><strong>Assume the environment does not allow you to store 64-bit integers.</strong>
 * Constraints:
 * <ul>
 *     <li>`-2^31 &le x &le 2^32 - 1`</li>
 * </ui></p>
 */
public class ReverseInteger {

    public static int reverse(int x) {
	int result;
	StringBuilder temp = new StringBuilder();
	boolean isNeg = x < 0;
	if (isNeg) {
	    temp.append('-');
	}
	int posX = isNeg ? Math.abs(x) : x;
        int div = posX;
	do {
	    int mod = div % 10;
	    temp.append(mod);
	    div /= 10;
	} while (div != 0);
	try {
	    result = Integer.parseInt(temp.toString());
	} catch (NumberFormatException e) {
	    result = 0;
	}
	return result;
    }


    public static void main(String[] args) {
	int x1 = 123;
	int x2 = -123;
	int x3 = 0;
	int x4 = 120;
	int x5 = Integer.MIN_VALUE;
	int x6 = Integer.MAX_VALUE;
	int x7 = 1_534_236_469;

	int[] xs = {x1, x2, x3, x4, x5, x6, x7};
	for (int x: xs) {
	    int y = reverse(x);
	    String z = Integer.toString(x);
	    out.printf("x:\t%d\ny:\t%d\nz:\t%s\n\n", x, y, z);
	}
    }
}
