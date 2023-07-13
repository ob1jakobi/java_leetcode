import java.util.*;                  // Includes Arrays (for printing array) and HashSet
import static java.lang.System.out;

/**
 * Given an integer array <code>nums</code>, return <code>true</code> if any value appears <strong>at least
 * twice</strong> in the array, and return <code>false</code> if every element is distinct.
 */
public class ContainsDuplicate3 {

    /**
     * Uses a <code>HashSet</code> to keep track of which elements are present in the arg <code>nums</code>.
     * if an integer is already present, then we know there's a duplicate, so we return <code>true</code>;
     * however, if we have traversed the entire array and do not find any duplicates, then we return
     * <code>false</code>.
     */
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
	int[] nums3 = {1,2,2,3,3,3,4,4,4,4};
	int[][] allNums = {nums1, nums2, nums3};

	boolean[] expectedResults = {true, false, true};
	for (int i = 0; i < expectedResults.length; i++) {
	    int[] nums = allNums[i];
	    boolean expected = expectedResults[i];
	    boolean result = containsDuplicate(nums);
	    out.printf("nums:\t\t%s\nexpected:\t%b\nresult:\t\t%b\n\n",
		   Arrays.toString(nums),
		   expected,
		   result);
	}
    }
}
