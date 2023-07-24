import static java.lang.System.out;
import java.util.Arrays;


/**
 * <p>Given an integer <code>n</code>, return <em>the number of prime numbers that are strictly less than
 * <code>n</code></em>.<br>
 *
 * Constraints:
 * <ul>
 *    <li>0 &le n &le 5 * 10^6</li>
 * </ul></p>
 */
public class CountPrimes {


    /**
     *
     */
    public static int countPrimes(int n) {
        boolean[] isPrimes;
	int i, j, result;

	// The first prime number is 2 -> if n is 0, 1, 2 the answer is 0, because n is exclusive
        if (n < 3) {
	    return 0;
	}

	isPrimes = new boolean[n];            //  0  1  2  3
	Arrays.fill(isPrimes, 2, n, true);    // [F, F, T, T, ...]

	// You only have to iterate up to (and including) half of the elements in isPrimes.
	// As we iterate the sieve with j, we're reducing the results each time
	for (i = 0; i <= n / 2; i++) {
	    if (!isPrimes[i]) {
		continue;
	    }
	    for (j = i * i; j < n; j += i) {
		isPrimes[j] = false;
	    }
	}

	result = 0;
	for (boolean b: isPrimes) {
	    result = b ? ++result : result;
	}

	return result;
    }

    public static void main(String[] args) {
	int[] results = {0,0,0,1,2,2,3,3,4,4,4,4,5,5,6,6,6,6,7,7,8,8,8,8};
        for (int i = 0; i <= 23; i++) {
	    int result = countPrimes(i);
	    boolean isCorrect = result == results[i];
	    out.printf("n:\t\t%d\nresult:\t\t%d\ncorrect:\t%b\n\n",
		       i,
		       result,
		       isCorrect);
	}
    }
}
