package Medium;

import java.util.Arrays;
import java.util.HashMap;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefixMultiplicationArr = new int[nums.length];
        int[] postfixMultiplicationArr = new int[nums.length];
        for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            prefixMultiplicationArr[i] = i == 0 ? nums[i] : nums[i] * prefixMultiplicationArr[i - 1];
            postfixMultiplicationArr[j] = j == nums.length - 1 ? nums[j] : nums[j] * postfixMultiplicationArr[j + 1];
        }
        for (int i = 0; i < result.length; i++) {
            int prefix = i == 0 ? 1 : prefixMultiplicationArr[i - 1];
            int postfix = i == result.length - 1 ? 1 : postfixMultiplicationArr[i + 1];
            result[i] = prefix * postfix;
        }
        return result;
    }

    /*
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefixMultArr = new int[nums.length];
        prefixMultArr[0] = nums[0];
        int[] postfixMultArr = new int[nums.length];
        postfixMultArr[nums.length - 1] = nums[nums.length - 1];
        // Fill prefix multiplication array
        for (int i = 1; i < nums.length; i++) {
            prefixMultArr[i] = nums[i] * prefixMultArr[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            postfixMultArr[j] = nums[j] * postfixMultArr[j + 1];
        }
        for (int i = 0; i < result.length; i++) {
            int prefixMultiple = i == 0 ? 1 : prefixMultArr[i - 1];
            int postfixMultiple = i == nums.length - 1 ? 1 : postfixMultArr[i + 1];
            result[i] = prefixMultiple * postfixMultiple;
        }
        System.out.println(Arrays.toString(prefixMultArr));
        System.out.println(Arrays.toString(postfixMultArr));
        return result;
    }
     */

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};

        int[][] all_nums = {nums1, nums2};
        for (int[] nums: all_nums) {
            System.out.printf("nums: %s,\tproductExceptSelf(nums): %s%n",
                    Arrays.toString(nums),
                    Arrays.toString(productExceptSelf(nums))
            );
        }
    }
}
