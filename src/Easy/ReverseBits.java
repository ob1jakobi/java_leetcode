import java.util.Arrays;
import java.util.Random;


/**
 * Reverse bits of a given 32-bit unsigned integer.
 *
 * Example:
 * input: -3             (1111 1111 1111 1111 1111 1111 1111 1100)
 * output: 1_071_741_823 (0011 1111 1111 1111 1111 1111 1111 1111) or (11 1111 1111 1111 1111 1111 1111 1111)
 */
public class ReverseBits {


    public static int reverseBits(int n) {
	int result = Integer.reverse(n);
	System.out.printf("\t%s,\t%s\n\n", Integer.toBinaryString(n), Integer.toBinaryString(result));
	return result;
    }

    public static void main(String[] args) {
	Random r = new Random();
	System.out.println("   n     \tbits");
	System.out.println("_________\t__________");
	for (int i = 0; i < 10; i++) {
	    int n = r.nextInt();
	    System.out.printf("%d,", n);
	    reverseBits(n);
	}
    }
}
