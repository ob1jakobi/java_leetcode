package Medium;

import java.util.*;

public class TopKFrequentElements {

    /**
     * <p>
     *     Each index in counts corresponds to the frequency/count of elements in nums.
     *     Each element in counts is an ArrayList of the numbers that occur at the given frequency.
     * </p>
     * <p>
     *     The <code>HashMap</code>, <code>numAndFreq</code>, has for its keys each distinct number/element in the
     *     array <code>nums</code>. The values mapped to each respective key is the frequency at which that element
     *     occurs in the array <code>nums</code>.
     * </p>
     * Example:<br>
     * <code>nums = [1,3,5,7,11,13,17,3,3,5,17,17]<br>
     * k = 3<br><br>
     * numAndFreq =<br>
     * {<br>
     * &emsp; 17 &emsp;-> 3,<br>
     * &emsp; 1 &emsp; -> 1,<br>
     * &emsp; 3 &emsp; -> 3,<br>
     * &emsp; 5 &emsp; -> 2,<br>
     * &emsp; 7 &emsp; -> 1,<br>
     * &emsp; 11 &emsp;-> 1,<br>
     * &emsp; 13 &emsp;-> 1,<br>
     * }<br>
     * counts =<br>
     * [<br>
     * &emsp; (0) &emsp; [],<br>
     * &emsp; (1) &emsp; [1, 7, 11, 13],<br>
     * &emsp; (2) &emsp; [5],<br>
     * &emsp; (3) &emsp; [17, 3],<br>
     * &emsp; (4) &emsp; [],<br>
     * &emsp; (5) &emsp; [],<br>
     * &emsp; (6) &emsp; [],<br>
     * &emsp; (7) &emsp; [],<br>
     * &emsp; (8) &emsp; [],<br>
     * &emsp; (9) &emsp; [],<br>
     * &emsp; (10)&emsp; [],<br>
     * &emsp; (11)&emsp; [],<br>
     * &emsp; (12)&emsp; []<br>
     * ]</code>
     * <p>
     *     The result:&emsp; <code>[17, 3, 5]</code>
     * </p>
     *
     * @param nums an array of integers with the following constraints:<br>
     *             <ul>
     *                 <code>
     *                     <li>1 &le; nums.length &le; 10<sup>5</sup><br></li>
     *                     <li>-10<sup>4</sup> &le; nums[i] &le; 10<sup>4</sup></li>
     *                 </code>
     *             </ul>
     * @param k the number of entries in the return array that are the k<sup>th</sup> most frequently occurring
     *          numbers in the parameter array <code>nums</code>. <code>k</code> is in the range <code>[1, the number of
     *          unique elements in the array]</code>
     * @return an integer array comprised of the <code>k<sup>th</sup></code> most frequently occurring numbers in <code>
     *     nums</code>.
     */
    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] counts = new List[nums.length + 1];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = new ArrayList<>();
        }
        HashMap<Integer, Integer> numAndFreq = new HashMap<>();
        for (int num: nums) {
            numAndFreq.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry: numAndFreq.entrySet()) {
            int count = entry.getValue();
            int num = entry.getKey();
            counts[count].add(num);
        }
        int[] result = new int[k];
        int j = counts.length - 1;
        int i = 0;
        while (i < result.length) {
            while (counts[j].isEmpty()) {
                j--;
            }
            for (int num: counts[j]) {
                result[i++] = num;
            }
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int[] nums2 = {1};
        int[] nums3 = {1,3,5,7,11,13,17,3,3,5,17,17};
        int[] nums4 = {1,2,2,3,3,3,4,4,4,4,3,5,7,11,5,7,7,11,11,13,5,13,11,7,13};

        int[][] all_nums = {nums1, nums2, nums3, nums4};
        int[] keys = {2, 1, 3, 4};
        int i = 0;
        for (int[] nums: all_nums) {
            int key = keys[i++];
            System.out.printf("nums: %s,\ttopKFrequent(nums): %s%n",
                    Arrays.toString(nums),
                    Arrays.toString(topKFrequent(nums, key)));
        }
    }

    /*  Textbook solution to the problem below
    int[] keys;
    HashMap<Integer, Integer> frequencyCounts = new HashMap<>();


    public void swap(int i, int j) {
        int temp = this.keys[i];
        this.keys[i] = this.keys[j];
        this.keys[j] = temp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot_frequency = frequencyCounts.get(keys[pivot_index]);
        swap(pivot_index, right);
        int stored_index = left;

        for (int i = left; i <= right; i++) {
            if (frequencyCounts.get(keys[i]) < pivot_frequency) {
                swap(stored_index, i);
                stored_index++;
            }
        }
        swap(stored_index, right);
        return stored_index;
    }

    public void quickSelect(int left, int right, int k_smallest) {
        if (left == right) {
            return;
        }
        Random rand = new Random();
        int pivot_index = left + rand.nextInt(right - left);
        pivot_index = partition(left, right, pivot_index);

        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            quickSelect(left, pivot_index - 1, k_smallest);
        } else {
            quickSelect(pivot_index + 1, right, k_smallest);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        for (int num: nums) {
            this.frequencyCounts.merge(num, 1, Integer::sum);
        }

        int n = frequencyCounts.size();
        this.keys = new int[n];
        int i = 0;
        for (int key: this.frequencyCounts.keySet()) {
            this.keys[i++] = key;
        }
        quickSelect(0, n - 1, n - k);

        return Arrays.copyOfRange(this.keys, n - k, n);
    }

    public static void main(String[] args) {
        TopKFrequentElements problem = new TopKFrequentElements();
        int[] nums1 = {1,1,1,2,2,3};
        int[] nums2 = {1};
        int[] nums3 = {1,2,2,3,3,3,4,4,4,4,3,5,7,11,5,7,7,11,11,13,5,13,11,7,13};

        int[][] all_nums = {nums1, nums2, nums3};
        int[] keys = {2, 1, 4};
        int i = 0;
        for (int[] nums: all_nums) {
            int key = keys[i];
            System.out.printf("nums: %s,\ttopKFrequent(nums): %s%n",
                    Arrays.toString(nums),
                    Arrays.toString(problem.topKFrequent(nums, key)));
            i++;
        }
    }
     */
}
