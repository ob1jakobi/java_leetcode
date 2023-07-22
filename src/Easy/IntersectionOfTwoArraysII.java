import java.util.*;         // Provides HashMap, ArrayList, Arrays
import static java.lang.System.out;

/**
 * <p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, return an <em>array of their 
 * intersection</em>. Each element in the result must appear as many times as it shows in both arrays and you
 * may return the result in <stron>any order</strong>.</p>
 *
 * Constraints:
 * <ul>
 *    <li>1 &le nums1.length, nums2.length &le 1000</li>
 *    <li>0 &le nums1[i], nums2[i] &le 1000</li>
 * </ul>
 */
public class IntersectionOfTwoArraysII {


    /**
     * 
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
	HashMap<Integer, Integer> counts1 = new HashMap<>();
	HashMap<Integer, Integer> counts2 = new HashMap<>();
	ArrayList<Integer> counts = new ArrayList<>();
	int[] result;

	// Fill each counts HashMap with the respective count for each number
	for (int num: nums1) {
	    counts1.merge(num, 1, Integer::sum);
	}
	for (int num: nums2) {
	    counts2.merge(num, 1, Integer::sum);
	}
	
	for (Map.Entry<Integer,Integer> entry: counts1.entrySet()) {
	    int num = entry.getKey();
	    int count1 = entry.getValue();
	    if (counts2.containsKey(num)) {
		int count2 = counts2.get(num);
		int minCount = Math.min(count1, count2);
		while (minCount > 0) {
		    counts.add(num);
		    minCount--;
		}
	    }
	}
	result = new int[counts.size()];
	for (int i = 0; i < result.length; i++) {
	    result[i] = counts.get(i);
	}
	return result;
    }

    /**
     *
     */
    public static int[] intersectSorted(int[] nums1, int[] nums2) {
	Arrays.sort(nums1);
	Arrays.sort(nums2);
	ArrayList<Integer> counts = new ArrayList<>();
	int[] result;

	int i = 0;
	int j = 0;
	while (i < nums1.length && j < nums2.length) {
	    int num1 = nums1[i];
	    int num2 = nums2[j];
	    if (num1 == num2) {
		counts.add(num1);
		i++;
		j++;
	    } else if (num1 < num2) {
		i++;
	    } else {
		j++;
	    }
	}
	result = new int[counts.size()];
	for (i = 0; i < result.length; i++) {
	    result[i] = counts.get(i);
	}
	return result;
    }

    public static void main(String[] args) {
	int[] nums1 = {1,2,2,1};
	int[] nums2 = {2,2};
	int[] nums3 = {4,9,5};
	int[] nums4 = {9,4,9,8,4};

	int[][] num1s = {nums1, nums3};
	int[][] num2s = {nums2, nums4};

	for (int i = 0; i < 2; i++) {
	    int[] num1 = num1s[i];
	    int[] num2 = num2s[i];
	    int[] result = intersect(num1, num2);
	    int[] resultSorted = intersectSorted(
						 Arrays.copyOf(num1, num1.length),
						 Arrays.copyOf(num2, num2.length)
						 );

	    out.printf("num1:\t\t%s\nnum2:\t\t%s\nresult:\t\t%s\nresultSorted:\t%s\n\n",
		       Arrays.toString(num1),
		       Arrays.toString(num2),
		       Arrays.toString(result),
		       Arrays.toString(resultSorted));
	}
    }
}
