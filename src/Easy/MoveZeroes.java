import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
	out.println("Entered moveZeroes");
	out.printf("nums:\t%s%n", Arrays.toString(nums));
        int l = 0;
	int r = 1;
	while (r < nums.length) {
	    int lNum = nums[l];
	    int rNum = nums[r];

	    // Check if lNum needs to be swapped or incremented
	    if (lNum == 0) {
	        // If rNum is valid, then swap the numbers; increment l IFF a swap occurs
		if (rNum != 0) {
		    nums[l] = rNum;
		    nums[r] = lNum;
		    l++;
		}
	    } else {
		// l points to a valid number, so increment l
		l++;
	    }
	    // Ensures that r is on the right by incrementing r every iteration
	    r++;
	}
	out.printf("nums:\t%s%n", Arrays.toString(nums));
	out.println("Leaving moveZeroes\n");
    }


    public static void main(String[] args) {
        Random r = new Random();
	int[] nums1 = {0,1,0,3,12};
	int[] nums2 = {0};
	int[] nums3 = {0,1,0,2,0,3,0,4,0,5,0};
	int[] nums4 = {1,2,3,4,5,0,0,0,0,0,0};
	int[] nums5 = {0,0,0,0,0,0};
	int[] nums6 = {1,0,1};
	int[] nums7 = {0,1,0};
	int[] nums8 = new int[r.nextInt(10)];
	for (int i = 0; i < nums8.length; i++) {
	    if (i % 7 == 0) {
		nums8[i] = 0;
	    } else {
		nums8[i] = r.nextInt();
	    }
	}

	int[][] allNums = {nums1, nums2, nums3, nums4, nums5, nums6, nums7, nums8};
	for (int[] nums: allNums) {
	    moveZeroes(nums);
	}
    }
}

