import static java.lang.System.out;
import java.util.Arrays;

/**
 * <p>You are given two integer arrays, <code>nums1</code> and <code>nums2</code>, sorted in
 * <strong>non-decreasing order</code>, and two integers <code>m</code> and <code>n</code>, representing
 * the number of elements in <code>nums1</code> and <code>nums2</code>, respectively.</p>
 *
 * <p><strong>Merge</strong> <code>nums1</code> and <code>nums2</code> into a single array sorted
 * in <strong>non-decreasing order</strong>.</p>
 *
 * <p>The final sorted array should not be returned by the function, but instead be <em>sorted inside
 * the array</em><code>nums1</code>. To accomplish this, <code>nums1</code> has a length of
 * <code>m + n</code>, where the first <code>m</code> elements denote the elements that should be
 * merged, and the last <code>n</code> elements are set to 0 and should be ignored. <code>nums2</code>
 * has a length of <code>n</code></p>
 *
 * <p>Constraints:
 *
 * <ul>
 *    <li>`nums1.length == m + n`</li>
 *    <li>`nums2.length == n`</li>
 *    <li>`0 &le m, n &le 200`</li>
 *    <li>`1 &le m + n &le 200`</li>
 *    <li>`-10^9 &le nums1[i], nums2[j] &le 10^9`</li>
 * </ul></p>
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] allSorted = new int[m + n];
		int i, p1, p2, n1, n2;
		
		p1 = 0;
		p2 = 0;

		for (i = 0; i < allSorted.length; i++) {
		    n1 = p1 < m ? nums1[p1] : Integer.MAX_VALUE;
		    n2 = p2 < n ? nums2[p2] : Integer.MAX_VALUE;
		    allSorted[i] = Math.min(n1, n2) == n1 ? nums1[p1++] : nums2[p2++];
		}

		for (i = 0; i < allSorted.length; i++) {
		    nums1[i] = allSorted[i];
		}
	}

    public static void main(String[] args) {
		int[] nums1a = {1,2,3,0,0,0};
		int[] nums1b = {1};
		int[] nums1c = {0};
		int[][] nums1s = {nums1a, nums1b, nums1c};

		int[] nums2a = {2,5,6};
		int[] nums2b = {};
		int[] nums2c = {1};
		int[][] nums2s = {nums2a, nums2b, nums2c};

		int[] ms = {3, 1, 0};
		int[] ns = {3, 0, 1};

		for (int i = 0; i < 3; i++) {
			int[] nums1 = nums1s[i];
			int[] nums2 = nums2s[i];
			int m = ms[i];
			int n = ns[i];
			out.printf("nums1:\t%s\nnums2:\t%s\nm:\t%d\nn:\t%d\n",
					Arrays.toString(nums1),
					Arrays.toString(nums2),
					m,
					n);
			merge(nums1, m, nums2, n);
			out.printf("result:\t%s\n\n", Arrays.toString(nums1));
		}
    }
    
}
