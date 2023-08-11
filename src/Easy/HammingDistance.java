import java.util.Random;
import java.util.Arrays;
import java.lang.StringBuilder;


/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are
 * different. Given two integers <code>x</code> and <code>y</code>, return the <em><strong>Hamming distance
 * </strong> between them</em>.<br><br>
 *
 * Constraints:
 * <ul>
 *    <li>0 &le x, y &le 2^31 - 1</li>
 * </ul>
 */
public class HammingDistance {

    /**
     * Because the Hamming distance refers to the number of bits that are different (i.e., where there's
     * an XOR case), this implementation creates two <code>char[]</code> that represent the bits in a 32-bit
     * integer. Wherever there is a bit bit difference, the <code>result</code> variable is incremented.
     * After iterating over both arrays, the sum of the differences are returned.
     */
    public static int hammingDistance(int x, int y) {
	boolean isXOR;
	char[] xArr, yArr;
	int i, j, result;
	String xS, yS;

	xArr = new char[31];
	yArr = new char[31];
	Arrays.fill(xArr, '0');
	Arrays.fill(yArr, '0');

	xS = Integer.toBinaryString(x);
	yS = Integer.toBinaryString(y);

	j = xArr.length - 1;
	for (i = xS.length() - 1; i >= 0; i--) {
	    xArr[j--] = xS.charAt(i);
	}
	j = yArr.length - 1;
	for (i = yS.length() - 1; i >= 0; i--) {
	    yArr[j--] = yS.charAt(i);
	}

	result = 0;
	for (i = 0; i < xArr.length; i++) {
	    isXOR = xArr[i] != yArr[i];
	    result += isXOR ? 1 : 0;
	}
	return result;
    }

    /**
     * This function uses the <code>Integer</code> class's <code>bitCount</code> method to do all of the
     * heavy lifting. By XOR-ing the two arguments in the <code>bitCount</code> method, the 2's compliment
     * binary representation of each integer is returned by the function, which is an O(1) method of doing
     * the above, except much more efficiently and succinctly.
     */
    public static int hammingDistanceAlt(int x, int y) {
	return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
	int x, x1, x2, x3, x4, x5, x6, x7;
	int y, y1, y2, y3, y4, y5, y6, y7;
	Random r;

	r = new Random();

	x1 = 1;
	x2 = 3;
	x3 = r.nextInt(Integer.MAX_VALUE);
	x4 = r.nextInt(Integer.MAX_VALUE);
	x5 = r.nextInt(Integer.MAX_VALUE);
	x6 = r.nextInt(Integer.MAX_VALUE);
	x7 = r.nextInt(Integer.MAX_VALUE);

	y1 = 4;
	y2 = 1;
	y3 = r.nextInt(Integer.MAX_VALUE);
	y4 = r.nextInt(Integer.MAX_VALUE);
	y5 = r.nextInt(Integer.MAX_VALUE);
	y6 = r.nextInt(Integer.MAX_VALUE);
	y7 = r.nextInt(Integer.MAX_VALUE);

	int[] xs = {x1, x2, x3, x4, x5, x6, x7};
	int[] ys = {y1, y2, y3, y4, y5, y6, y7};
	for (int i = 0; i < xs.length; i++) {
	    x = xs[i];
	    y = ys[i];
	    System.out.printf("x:\t%d\t%s\ny:\t%d\t%s\nr1:\t%d\nr2:\t%d\n\n",
			      x,
			      Integer.toBinaryString(x),
			      y,
			      Integer.toBinaryString(y),
			      hammingDistance(x, y),
			      hammingDistanceAlt(x, y));
	}
    }
}
