

public class RotateImage {
    int[][] m1 = {
	{1,2,3},
	{4,5,6},
	{7,8,9}
    };

    int[][] m2 = {
	{5,1,9,11},
	{2,4,8,10},
	{13,3,6,7},
	{15,14,12,16}
    };

    int[][] r1 = {
	{7,4,1},
	{8,5,2},
	{9,6,3}
    };

    int[][] r2 = {
	{15,13,2,5},
	{14,3,4,1},
	{12,6,8,9},
	{16,7,10,11}
    };

    /**
     * The intuition is that - no matter the size of the matrix - you'll always be dealing with an <code>n
     * x n</code> matrix.  This means that for each element, you'll have to rotate it <em>at most</em> 4 times;
     * this number is lower if you have an odd number for n, since the innermost number won't actually be
     * rotated.
     * 
     */
    public static void rotate(int[][] matrix) {
	int n = matrix.length;
        // TODO:
    }

    public static void main(String[] args) {
	
    }
}
