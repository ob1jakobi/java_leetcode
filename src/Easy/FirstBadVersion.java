import static java.lang.System.out;
import java.util.Random;


/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of our product fails the quality check. Since each version is developed based on
 * the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have <code>n</code> versions <code>[1, 2, ..., n]</code> and you want to find out the
 * the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API <code>bool isBadVersion(version)</code> which returns whether <code>version</code>
 * is bad. Implement a function to find the first bad version. You should minimize the number of
 * calls to the API.
 *
 * Constraints:
 * <ul>
 *    <li>1 &le badVersion &le n &le 2^31 - 1</li>
 * </ul>
 */
public class FirstBadVersion {

    int badVersion;
    int n;

    public FirstBadVersion(int n, int badVersion) {
        this.n = n;
	this.badVersion = badVersion;
    }

    public boolean isBadVersion(int version) {
	return version >= this.badVersion;
    }

    /**
     * This version uses Binary Search to find the first bad value. When performing Binary Search,
     * you find the mid-point by performing <code>(lo + hi) / 2</code>. If all numeric  variables
     * are of type <code>int</code>, then the sum of the numerator could overflow when evaluated.
     * This is possible because both <code>n</code> and <code>badVersion</code> could be 
     * <code>Integer.MAX_VALUE</code>. This would mean that, as you approach <code>hi</code>, which would
     * be the same as <code>n == badVersion</code>, <code>lo</code> would increasingly approach the
     * same upper boundary of <code>int</code> width. The best way to avoid this is to use <code>long</code>
     * types for all numeric values; this way if you have to sum 
     * <code>(Integer.MAX_VALUE - 1) + Integer.MAX_VALUE</code>, the overall result would be < Long.MAX_VALUE;
     */
    public int firstBadVersion(int n) {
	boolean isBad;
	long lo, mid, hi;

	lo = 1L;
	hi = (long) n;
	while (lo < hi) {
	    mid = (lo + hi) / 2;
	    isBad = isBadVersion((int) mid);
	    if (isBad) {
		hi = mid;
	    } else {
		lo = mid + 1;
	    }
	}
	return (int) lo;
    }


    /* The version that the editorial shows
    public int firstBadVersion(int n) {
	boolean isBad;
        int lo, mid, hi;

	lo = 1;
	hi = n;
	while (lo < hi) {
	    mid = lo + (hi - lo) / 2;
	    isBad = isBadVersion(mid);
	    if (isBad) {
		hi = mid;
	    } else {
		lo = mid + 1;
	    }
	}
	return lo;
    }
    */

    public static void main(String[] args) {
	Random r = new Random();
	FirstBadVersion b1 = new FirstBadVersion(5, 4);
	FirstBadVersion b2 = new FirstBadVersion(1, 1);
	int n3 = r.nextInt(Integer.MAX_VALUE);
	int bv3 = r.nextInt(n3);
	FirstBadVersion b3 = new FirstBadVersion(n3, bv3);
	int n4 = r.nextInt(Integer.MAX_VALUE);
	int bv4 = r.nextInt(n4);
	FirstBadVersion b4 = new FirstBadVersion(n4, bv4);
	int n5 = r.nextInt(Integer.MAX_VALUE);
	int bv5 = r.nextInt(n5);
	FirstBadVersion b5 = new FirstBadVersion(n5, bv5);
	int n6 = r.nextInt(Integer.MAX_VALUE);
	int bv6 = r.nextInt(n6);
	FirstBadVersion b6 = new FirstBadVersion(n6, bv6);
	int n7 = r.nextInt(Integer.MAX_VALUE);
	int bv7 = r.nextInt(n7);
	FirstBadVersion b7 = new FirstBadVersion(n7, bv7);

	FirstBadVersion[] bs = {b1, b2, b3, b4, b5, b6, b7};
	for (FirstBadVersion b: bs) {
	    int bv = b.badVersion;
	    int n = b.n;
	    int re = b.firstBadVersion(n);
	    out.printf("bv:\t%d\nn:\t%d\nr:\t%d\n\n", bv, n, re);
	}
    }
}
