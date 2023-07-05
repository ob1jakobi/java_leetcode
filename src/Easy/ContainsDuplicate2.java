import java.util.HashSet;
import java.util.Arrays;

public class ContainsDuplicate2 {
    public static boolean containsDuplicate(int[] nums) {
	HashSet<Integer> set = new HashSet<>();
	for (int num: nums) {
	    if (set.contains(num)) {
		return true;
	    }
	    set.add(num);
	}
	return false;
    }

    public static void main(String[] args) {
	int[] nums1 = {1,2,3,1};
	int[] nums2 = {1,2,3,4};
	int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
	int[] nums4 = {1};

	int[][] all_nums = {nums1, nums2, nums3, nums4};
	for (int[] nums: all_nums) {
	    System.out.printf("containsDuplicate(%s) -> %b%n",
			       Arrays.toString(nums),
			       containsDuplicate(nums));
	}
    }
}
