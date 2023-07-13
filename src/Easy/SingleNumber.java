import static java.lang.System.out;
import java.util.Arrays;


/**
 * Given a <strong>non-empty</strong> array of integers <code>nums</code>, every element appears <em>twice</em>
 * except for one. Find that single one. You must implement a solution with a linear runtime complexity and
 * use only constant extra space.
 */
public class SingleNumber {

    /**
     * Converts a decimal integer to a <code>String</code> of the 4-digit binary representation of the same
     * number.
     */
    public static String asBinaryString(int num) {
	return String.format("%4s", Integer.toBinaryString(num)).replace(' ', '0');
    }

    /**
     * The solution uses the bits manipulation to identify the single unique number. The operation being used
     * is XOR, i.e., (p v q) ^ ~(p ^ q). Two concepts regarding XOR apply to this implementation:
     * <ul>
     *    <li>Any number that is XOR-ed with 0 is that same number, and</li>
     *    <li>Any number that is XOR-ed with itself is 0.</li>
     * </ul>
     * Because there are two copies of each number in <code>nums</code> - except for one number - we can create
     * a variable, <code>result</code> that is initialized to <code>0</code>. We iterate over <code>nums</code>
     * and update <code>result</code> to be the current value of <code>result</code> XOR-ed against the iterated
     * number. If every single number in <code>nums</code> were duplicated exactly twice, then <code>result</code>
     * would return <code>0</code>; however, since there is <em>one</em> number that is not duplicated, then the
     * final value of <code>result</code> will be that non-duplicated number.
     */
    public static int singleNumber(int[] nums) {
	out.println("nums:\t\t" + Arrays.toString(nums));
	int result = 0;
	for (int num: nums) {
	    result = result ^ num;
	}
	return result;
    }

    /**
     * Same as the above, but it shows the work/steps.
     */
    public static int showWork(int[] nums) {
	out.printf("nums:\t%s\n", Arrays.toString(nums));
	// Only for printing
	int i = 1;
	
	int result = 0;
	for (int num: nums) {
	    // Only added for printing - does nothing
	    int temp = result;
	    // Acutal code needed for solution
	    result = result ^ num;
	    
	    out.printf("iteration #%d\n", i++);
	    out.printf("\tresult:\t%s\n\tnum:\t%s\n\tXOR:__________\n\tresult:\t%s\n\n",
		       asBinaryString(temp)   + " = " + temp,
		       asBinaryString(num)    + " = " + num,
		       asBinaryString(result) + " = " + result);
	}
	return result;
    }


    public static void main(String[] args) {
	int[] nums1 = {2,2,1};
	int[] nums2 = {4,1,2,1,2};
	int[] nums3 = {1};
	int[][] allNums = {nums1, nums2, nums3};

	int[] expectedResults = {1,4,1};

	for (int i = 0; i < allNums.length; i++) {
	    int[] nums = allNums[i];
	    int expected = expectedResults[i];
	    int result = singleNumber(nums);
	    out.printf("expected:\t%d\nresult:\t\t%d\n----------------------------------\n\n",
		       expected,
		       result);
	}
	/* Uncomment to see the work and steps.
	for (int i = 0; i < allNums.length; i++) {
	    int[] nums = allNums[i];
	    int expected = expectedResults[i];
	    int result = showWork(nums);
	    out.printf("expected:\t%d\nresult:\t\t%d\n----------------------------------\n\n",
		       expected,
		       result);
	}
	*/
    }
}
