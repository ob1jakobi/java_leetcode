package Medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf3 {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixArr = new int[n];
        int[] postfixArr = new int[n];
        int[] result = new int[n];

        // Fill the prefix array - iterate from start of nums
        for (int i = 0; i < n; i++) {
            prefixArr[i] = i == 0 ? nums[i] : nums[i] * prefixArr[i - 1];
        }
        // Fill the postfix array - iterate from end of nums
        for (int i = n - 1; i >= 0; i--) {
            postfixArr[i] = i == n - 1 ? nums[i] : nums[i] * postfixArr[i + 1];
        }
        // Fill the result array
        for (int i = 0; i < n; i++) {
            // If i == 0, then multiply by 1 because there's no prefix
            int prefix = i == 0 ? 1 : prefixArr[i - 1];
            // If i == n - 1, then multiply by 1 because there's no postfix
            int postfix = i == n - 1 ? 1 : postfixArr[i + 1];
            result[i] = prefix * postfix;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};
        int[] nums3 = {1,2,3,4,-1,1,0,-3,3};
        int[][] all_nums = {nums1, nums2, nums3};

        for (int[] nums: all_nums) {
            System.out.printf("productExceptSelf(%s) -> %s%n",
                    Arrays.toString(nums),
                    Arrays.toString(productExceptSelf(nums)));
        }
    }
}
