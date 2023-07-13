import java.util.Arrays;

public class RotateArray {

    /**
     * Uses O(2n) memory, but is done in O(n) time
     */
    public static void rotate(int[] nums, int k) {
	int n = nums.length;
	int[] swappedArr = new int[n];
	for (int i = 0; i < n; i++) {
	    int currentNum = nums[i];
	    int insertionIndex = (i + k) % n;
	    swappedArr[insertionIndex] = currentNum;
	}
	for (int i = 0; i < n; i++) {
	    nums[i] = swappedArr[i];
	}
    }



    public static void main(String[] args) {
	int[] nums1 = {1,2,3,4,5,6,7};
	int[] nums2 = {-1,-100,3,99};
	int[][] allNums = {nums1, nums2};

	int[] ks = {3,2};

	int[] answer1 = {5,6,7,1,2,3,4};
	int[] answer2 = {3,99,-1,-100};
	int[][] answers = {answer1, answer2};

	for (int i = 0; i < allNums.length; i++) {
	    int[] nums = allNums[i];
	    int[] numsPre = Arrays.copyOf(nums, nums.length);
	    int k = ks[i];
	    int[] answer = answers[i];
	    rotate(nums, k);
	    int[] result = nums;
	    boolean isCorrect = Arrays.equals(answer, result);
	    System.out.printf("nums:\t\t%s,\tk:\t%d\nanswer:\t\t%s\nresult:\t\t%s\ncorrect:\t%b\n\n",
			      Arrays.toString(numsPre),
			      k,
			      Arrays.toString(answer),
			      Arrays.toString(result),
			      isCorrect);
	}
    }
}
