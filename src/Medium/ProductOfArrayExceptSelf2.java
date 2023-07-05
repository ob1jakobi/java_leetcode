import java.util.*;

public class ProductOfArrayExceptSelf2 {

    public static int[] productExceptSelf(int[] nums) {
	int[] prefixArr = new int[nums.length];
	int[] postfixArr = new int[nums.length];
	int[] result = new int[nums.length];

	for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
	    prefixArr[i] = i == 0 ? nums[i] : nums[i] * prefixArr[i - 1];
	    postfixArr[j] = j == nums.length - 1 ? nums[j] : nums[j] * postfixArr[j + 1];
	}

	for (int i = 0; i < result.length; i++) {
	    int prefix = i == 0 ? 1 : prefixArr[i - 1];
	    int postfix = i == result.length - 1 ? 1 : postfixArr[i + 1];
	    result[i] = prefix * postfix;
	}
	return result;
    }

    public static void main(String[] args) {
	int[] nums1 = {1,2,3,4};
	int[] nums2 = {-1,1,0,-3,3};

	int[][] all_nums = {nums1, nums2};

	for (int[] nums: all_nums) {
	    System.out.printf("productExceptself(%s) -> %s%n",
			      Arrays.toString(nums),
			      Arrays.toString(productExceptSelf(nums)));
	}
    }
}
