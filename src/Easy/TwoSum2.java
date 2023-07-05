import java.util.HashMap;
import java.util.Arrays;

public class TwoSum2 {

    public static int[] twoSum(int[] nums, int target) {
	HashMap<Integer, Integer> num_and_index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
	    int complement = target - nums[i];

	    if (num_and_index.containsKey(complement)) {
		return new int[] {num_and_index.get(complement), i};
	    }
	    num_and_index.put(nums[i], i);
	}
	return null;
    }

    public static void main(String[] args) {
	int[] nums1 = {2,7,11,15};
	int[] nums2 = {3,2,4};
	int[] nums3 = {3,3};

	int target1 = 9;
	int target2 = 6;

	int[][] all_nums = {nums1, nums2, nums3};
	int[] all_targets = {target1, target2};

	for (int[] nums: all_nums) {
	    for (int target: all_targets) {
		System.out.printf("twoSum(%s, %d) -> %s%n",
				  Arrays.toString(nums),
				  target,
				  Arrays.toString(twoSum(nums, target)));
	    }
	}
    }
}
