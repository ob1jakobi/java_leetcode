import java.util.Arrays;
import java.util.*;
import static java.lang.System.out;


public class ShuffleAnArray {

    int[] nums;
    HashSet<Integer> indices;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
	this.indices = new HashSet<>(nums.length);
	for (int i = 0; i < nums.length; i++) {
	    this.indices.add(i);
	}
    }

    public int[] reset() {
	return this.nums;
    }

    /**
     * Update using Hashing to index array; collisions unlikely due to
     * the elements in the array being unique.
     */
    public int[] shuffle() {
	int[] newNums = new int[this.nums.length];
	// TODO: use hashing.
	return newNums;
    }

    public static void main(String[] args) {
        int[] ns1 = new int[10];
	int[] ns2 = new int[10];
	int[] ns3 = new int[10];
	Random r = new Random();
	for (int i = 0; i < 10; i++) {
	    ns1[i] = r.nextInt(10);
	    ns2[i] = r.nextInt(10);
	    ns3[i] = r.nextInt(10);
	}
	ShuffleAnArray s1 = new ShuffleAnArray(ns1);
	ShuffleAnArray s2 = new ShuffleAnArray(ns2);
	ShuffleAnArray s3 = new ShuffleAnArray(ns3);

	ShuffleAnArray[] ss = {s1, s2, s3};
	for (ShuffleAnArray s: ss) {
	    out.println(Arrays.toString(s.reset()));
	    out.println(Arrays.toString(s.shuffle()));
	    out.println(Arrays.toString(s.shuffle()));
	    out.println();
	}
    }
}


