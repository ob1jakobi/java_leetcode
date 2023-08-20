import static java.lang.System.out;
import java.util.Arrays;


public class PracticeArgs {

    public static int[] oneVarargs(int... nums) {
	int[] result = new int[nums.length];
	for (int i = 0; i < result.length; i++) {
	    result[i] = nums[i];
	}
	return result;
    }

    public static int[] moreVarargs(int num1, int num2, int... nums) {
	int[] result = new int[nums.length + 2];
	result[0] = num1;
	result[1] = num2;
	for (int i = 2; i < result.length; i++) {
	    result[i] = nums[i - 2];
	}
	return result;
    }

    public static void main(String[] args) {
	int[] nums1 = new int[] {};
	int[] nums2 = {1,2,3,4,5,6,7,8,9,10};
	int[] nums3 = new int[9];
	int[] nums4 = new int[9];
	for (int i = 0; i < nums3.length; i++) {
	    nums3[i] = i;
	    nums4[i] = i * i;
	}
        int[][] ns = {nums1, nums2, nums3, nums4};
	for (int i = 0, j = 1; i < ns.length; i++, j*=2) {
	    int[] nums = ns[i];
	    out.printf("nums:%88s\n", Arrays.toString(nums));
	    out.printf("oneVarargs(%d):%50s\n", i, Arrays.toString(oneVarargs(i)));
	    out.printf("oneVarargs(%d, %d):%50s\n", i, j, Arrays.toString(oneVarargs(i, j)));
	    out.printf("oneVarargs(%s):%48s\n", Arrays.toString(nums), Arrays.toString(oneVarargs(nums)));
	    out.printf("moreVarargs(%d, %d, %d):%49s\n", i, j, i, Arrays.toString(moreVarargs(i, j, i)));
	    out.printf("moreVarargs(%d, %d, %d, %d):%49s\n", i, j, i, j, Arrays.toString(moreVarargs(i, j, i, j)));
	    out.printf("moreVarargs(%d, %d, %s):%47s\n\n", i, j, Arrays.toString(nums), Arrays.toString(moreVarargs(i, j, nums)));
	}
    }
}
