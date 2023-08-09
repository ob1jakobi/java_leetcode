


/**
 *
 */
public class NumberOf1Bits {

    public static int hammingWeight(int n) {
	int result;
        char[] arr;

	result = 0;
	arr == Integer.toBinaryString(n).toCharArray();
	for (char c: arr) {
	    result += Character.getNumericValue(c);
	}
	return result;
    }

    public static void main(String[] args) {
	// Blank
    }
}
