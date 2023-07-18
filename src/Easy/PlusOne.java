import static java.lang.System.out;
import java.util.Arrays;

/**
 * <p>You are given a <strong>large integer</strong> represented as an integer array <code>digits</code>, where
 * each <code>digits[i]</code> is the <code>i<sup>th</sup></code> digit of the integer. The digits are ordered
 * from most significant to least significant in left-to-right order. The large integer does not contain any
 * leading <code>0</code>'s.</p>
 *
 * <p>Increment the large integer by one and return <em>the resulting array of digits</em>.</p>
 *
 * <ul>
 *    <li>1 &le digits.length &le 100</li>
 *    <li>0 &le digits[i] &le 9</li>
 *    <li>`digits` does not contain any leading `0`'s.</li>
 * </ul>
 */
public class PlusOne {

    /**
     * <p>Implementation is based on the principle that we iterate over digits in reverse, since that's how most
     * addition is applied, especially if carrying over numbers. There are two numbers and a flag condition that
     * are taken into account for this algorithm:</p>
     *
     * <ul>
     *    <li>`shouldAddOne`: a `boolean` that indicates whether a we need to add one to the current
     *        iteration's number, `digit`.</li>
     *    <li>`digit`: represents the number currently iterated over in `digits`; starts as the right-most
     *        element in `digits`.</li>
     *    <li>`newDigit`: represents the number that may be different from `digit`. If the flag `shouldAddOne`
     *        indicates that we need to add one to `digit`, then this number will replace the current element
     *        int `digits` at the iterated index.</li>
     * </ul>
     *
     * <p>Under normal circumstances, if we have to add <code>1</code> to the currently iterated number,
     * <code>digit</code>, then <code>digit</code> will be less than <code>newDigit</code> because we've had 
     * to add <code>1</code> to its value when initializing <code>newDigit</code>. However, if <code>digit</code>
     * is <code>9</code> - and the flag indicates that we have to increment <code>digit</code> - then
     * <code>newDigit</code> will be become <code>0</code> because we're doing decimal-based addition. This
     * means that we'll have to continue adding <code>1</code> to the next iteration because we're carrying
     * over the addition. This can propigate all the way to the beginning of the array <code>digits</code>,
     * if - for example - <code>digits</code> is entirely populated with <code>9</code>.</p>
     *
     * <p>By the time that iteration has completed for the <code>digits</code> array, if the flag is still set,
     * then we know we need to create a brand new array that is larger than <code>digits</code> by one element.
     * So we create a new array <code>result</code> give its first element the value <code>1</code>, to account
     * for the carryover value, and make all remaining digits the same as they are in <code>digits</code>.
     * If the flag is not set, then we can initialize <code>result</code> to point to <code>digits</code>, since
     * we were able to do our addition in-place; alternatively, we could've just returned <code>digits</code>,
     * since <code>result</code> doesn't necessarily have to be initialized in this case.</p>
     */
    public static int[] plusOne(int[] digits) {
        boolean shouldAddOne = true;
	int[] result;

	for (int i = digits.length - 1; i >= 0; i--) {
	    int digit = digits[i];
	    int newDigit = shouldAddOne ? (digit + 1) % 10 : digit;
	    digits[i] = newDigit;
	    // If newDigit < digit, then digit == 9 and newDigit = 0, meaning we have to carry over addition
	    // to the next iteration.
	    if (newDigit > digit) {
		shouldAddOne = false;
		break;
	    }
	}

	if (shouldAddOne) {
	    result = new int[digits.length + 1];
	    result[0] = 1;
	    for (int i = 1; i < result.length; i++) {
		result[i] = digits[i - 1];
	    }
	} else {
	    result = digits;
	}
	
	return result;
    }

    public static void main(String[] args) {
	int[] digits1 = {1,2,3};
	int[] digits2 = {4,3,2,1};
	int[] digits3 = {9};
	int[] digits4 = {9,9,9,9,9};

	int[][] allDigits = {digits1, digits2, digits3, digits4};

	for (int i = 0; i < allDigits.length; i++) {
	    int[] digits = allDigits[i];
	    int[] result = plusOne(Arrays.copyOf(digits, digits.length));
	    out.printf("digits:\t%s\nresult:\t%s\n\n",
		       Arrays.toString(digits),
		       Arrays.toString(result));
	}
    }
}
