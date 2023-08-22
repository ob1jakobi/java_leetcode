import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


/**
 * Given an integer array, <code>nums</code>, return all the triplets <code>[nums[i], nums[j], nums[k]]</code>
 * such that <code>i != j</code>, <code>i != k</code>, and <code>j != k</code>, and 
 * <code>nums[i] + nums[j] + nums[k] == 0</code>.<br>
 * Notice that the solution set must not contain duplicate triplets.<br><br>
 *
 * Constraints:
 * <ul>
 *    <li>3 &le nums.length &le 3000</li>
 *    <li>-10^5 &le nums[i] &le 10^5</li>
 * </ul>
 */
public class ThreeSum {

    final static int TARGET = 0;   // The sum that nums[i] + nums[j] + nums[k] should add up to be.

    public static List<List<Integer>> threeSumHashSet(int[] nums) {
	Arrays.sort(nums);
	int i, j, num, complement;
	HashSet<Integer> seenNums;
	List<List<Integer>> result = new ArrayList<>();

        for (i = 0; i < nums.length && nums[i] <= ThreeSum.TARGET; i++) {
	    num = nums[i];
	    if (i == 0 || nums[i - 1] != num) {
		seenNums = new HashSet<>();
		for (j = i + 1; j < nums.length; j++) {
		    complement = (num * (-1)) - nums[j];
		    if (seenNums.contains(complement)) {
			result.add(Arrays.asList(num, nums[j], complement));
			while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
			    ++j;
			}
		    }
		    seenNums.add(nums[j]);
		}
	    }
	}
	return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
	int i, lo, hi, num, sum;
	List<Integer> temp;
        List<List<Integer>> result;

	result = new ArrayList<>();

        Arrays.sort(nums);
	for (i = 0; i < nums.length && nums[i] <= ThreeSum.TARGET; i++) {
	    num = nums[i];
	    
	    if (i == 0 || nums[i - 1] != num) {
		lo = i + 1;
		hi = nums.length - 1;
		while (lo < hi) {
		    sum = num + nums[lo] + nums[hi];
		    if (sum < ThreeSum.TARGET) {
			lo++;
		    } else if (sum > ThreeSum.TARGET) {
			hi--;
		    } else {
			temp = Arrays.asList(num, nums[lo++], nums[hi--]);
			result.add(temp);
			while (lo < hi && nums[lo] == nums[lo - 1]) {
			    ++lo;
			}
		    }
		}
	    }
	}
	return result;

	/* Below works
	for (i = 0; i < nums.length && nums[i] <= ThreeSum.TARGET; i++) {
	    if (i > 0 && nums[i - 1] == nums[i]) {
		continue;
	    }
	    lo = i + 1;
	    hi = nums.length - 1;
	    while (lo < hi) {
		sum = nums[i] + nums[lo] + nums[hi];
		if (sum < ThreeSum.TARGET) {
		    ++lo;
		} else if (sum > ThreeSum.TARGET) {
		    --hi;
		} else {
		    temp = Arrays.asList(nums[i], nums[lo++], nums[hi--]);
		    result.add(temp);
		    while (lo < hi && nums[lo] == nums[lo - 1]) {
			++lo;
		    }
		}
	    }
	}
	return result;
	*/
    }

    public static void main(String[] args) {
	Random r = new Random();
	
	int[] nums1 = {-1, 0, 1, 2, -1, 4};
	int[] nums2 = {0, 1, 1};
	int[] nums3 = {0, 0, 0};
	int[] nums4 = new int[20];
	for (int i = 0; i < nums4.length; i++) {
	    nums4[i] = r.nextInt(25) - 12;
	}

	int[][] ns = {nums1, nums2, nums3, nums4};
	for (int[] nums: ns) {
	    int[] sortedNums = Arrays.copyOf(nums, nums.length);
	    Arrays.sort(sortedNums);
	    System.out.printf("nums:\t%s\nsort:\t%s\nout1:\t%s\nout2:\t%s\n\n",
			      Arrays.toString(nums),
			      Arrays.toString(sortedNums),
			      threeSum(nums),
			      threeSumHashSet(nums));
	}
    }
}
