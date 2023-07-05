import java.util.*;

public class TopKFrequentElements2 {
    public static int[] topKFrequent(int[] nums, int k) {
	// Array of ArrayLists, where each index corresponds to the count/frequency of a given number in nums
        List<Integer>[] counts = new List[nums.length + 1];
	for (int i = 0; i < counts.length; i++) {
	    counts[i] = new ArrayList<>();
	}
	// The keys are the numbers in nums and their respective value is the count/frequency of occurrence
	HashMap<Integer, Integer> numAndCount = new HashMap<>();
	for (int num: nums) {
	    numAndCount.merge(num, 1, Integer::sum);
	}
	// Populate the counts array; the values from numAndCount are the indices, and the num is added to list
	for (Map.Entry<Integer, Integer> entry: numAndCount.entrySet()) {
	    int count = entry.getValue();
	    int num = entry.getKey();
	    counts[count].add(num);
	}
	// Create return array that has k number of elements
	int[] result = new int[k];
	int i = 0;                           // For indexing and populating the result array
	int j = counts.length - 1;           // For iterating over counts in reverse order
	while (i < k) {
	    // Skip to the highest non-empty count in counts array
	    while (counts[j].isEmpty()) {
		j--;
	    }
	    // Insert each num at highest count index in counts to the result array
	    for (int num: counts[j]) {
		result[i++] = num;
	    }
	    // Decrement j to get to the next non-empty count in counts to continue (assuming)
	    j--;
	}
	return result;
    }

    public static void main(String[] args) {
	int[] nums1 = {1,1,1,2,2,3};
	int[] nums2 = {1};

	int target1 = 2;
	int target2 = 1;

	int[][] all_nums = {nums1, nums2};
	int[] all_targets = {target1, target2};
	for (int[] nums: all_nums) {
	    for (int target: all_targets) {
		System.out.printf("topKFrequent(%s, %d) -> %s%n",
				  Arrays.toString(nums),
				  target,
				  Arrays.toString(topKFrequent(nums, target)));
	    }
	}
    }
}
