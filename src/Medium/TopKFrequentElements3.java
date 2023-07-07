package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements3 {

    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        HashMap<Integer, Integer> numAndFreq = new HashMap<>();
        // Array where each index corresponds to the frequency a given number occurs in nums
        ArrayList<Integer>[] counts = new ArrayList[n + 1];
        // Instantiate each ArrayList for each count
        for (int i = 0; i < n + 1; i++) {
            counts[i] = new ArrayList<>();
        }
        // Obtain the counts for each number
        for (int num: nums) {
            numAndFreq.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry: numAndFreq.entrySet()) {
            // Get a number that occurs in nums
            int number = entry.getKey();
            // Get that number's respective frequency/count in nums
            int frequency = entry.getValue();
            // Add that number to the ArrayList in counts
            counts[frequency].add(number);
        }
        // The highest counts are at the end of the counts array - so iterate over it in reverse order
        int i = 0;        // Index for filling the result array
        int j = n;        // Index for reverse iteration over the counts array
        while (i < k) {
            // Skip over the counts that don't have any numbers
            while (counts[j].isEmpty()) {
                j--;
            }
            // Iterate over each number that has the frequency at counts[j] and add that number to the result array
            for (int num: counts[j]) {
                result[i++] = num;
            }
            // Decrement j now that we've exhausted each number at that count frequency
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int[] nums2 = {1};

        int k1 = 2, k2 = 1;

        System.out.printf("topKFrequent(%s, %d) -> %s%n",
                Arrays.toString(nums1),
                k1,
                Arrays.toString(topKFrequent(nums1, k1)));

        System.out.printf("topKFrequent(%s, %d) -> %s%n",
                Arrays.toString(nums2),
                k2,
                Arrays.toString(topKFrequent(nums2, k2)));
    }
}
