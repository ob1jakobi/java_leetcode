import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
	int count = 1;                  // Guaranteed to have at least one element in nums
	int l = 0;                      // Unique number pointer
	int r = 1;                      // Current (possibly duplicate) number iterator ponter
	while (r < nums.length) {
	    int uniqueNum = nums[l];
	    int currNum = nums[r];
	    if (uniqueNum != currNum) {
		count++;                  // Increment count since new unique number has been found
		nums[++l] = currNum;      // Change next non-unique number in nums to unique num
	    }
	    r++;
	}
	return count;
    }

    public static void main(String[] args) {
	int[] nums1 = {1,1,2};
	int[] nums2 = {1,2,2,3,3,3,4,4,4,4};
	int[] nums3 = {1};
	int[] nums4 = {1,1,1,1};

	int[][] allNums = {nums1, nums2, nums3, nums4};
	for (int[] nums: allNums) {
	    System.out.printf("nums:\t%s\ncount:\t%d\nnums:\t%s\n\n",
			      Arrays.toString(nums),
			      removeDuplicates(nums),
			      Arrays.toString(nums));
	}
    }
}
