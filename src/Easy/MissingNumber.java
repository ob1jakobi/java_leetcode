


public class MissingNumber {


    public static int MissingNumber(int[] nums) {
        boolean[] isPresent = new boolean[nums.length + 1];
	for (int n: nums) {
	    isPresent[n] = true;
	}
	for (int i = 0; i < isPresent.length; i++) {
	    if (!isPresent[i]) {
		return i;
	    }
	}
	return -1;
    }

    public static void main(String[] args) {

	
    }
}
