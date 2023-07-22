import java.lang.StringBuilder;
import java.util.Arrays;
import static java.lang.System.out;

public class RotateImage {
    static int[][] m1 = {
	{1,2,3},
	{4,5,6},
	{7,8,9}
    };

    static int[][] m2 = {
	{5,1,9,11},
	{2,4,8,10},
	{13,3,6,7},
	{15,14,12,16}
    };

    static int[][] r1 = {
	{7,4,1},
	{8,5,2},
	{9,6,3}
    };

    static int[][] r2 = {
	{15,13,2,5},
	{14,3,4,1},
	{12,6,8,9},
	{16,7,10,11}
    };

    static int[][][] allMatrices = {m1, m2, r1, r2};

    /**
     * <p>The intuition is that - no matter the size of the matrix - you'll be rotating an entire row/column.
     * So, for the matrix <code>m1</code> above, the first row <code>[1, 2, 3]</code> will become the right-side
     * of the matrix (or column):<br>
     * <code>1</code><br>
     * <code>2</code><br>
     * <code>3</code><br>
     * The same process will occur with both the left and right columns, as well as the bottom row.</p>
     */
    public static void rotate(int[][] matrix) {
	out.println("Beginning rotate()\n");
        printMatrix(matrix);
	int n = matrix.length - 1;
        int LB = 0;
	int RB = n;
	while (LB < RB) {
	    // Because this is a square, the top and bottom boundaries should be equal to the left and right bounds.
	    int TOP = LB;
	    int BOT = RB;
	    // Special termination length, since we're cinching up the distances with each concentric square
	    // The first square has the full length, but the next square is decreased because we're incrementing
	    // the LB and decrementing the RB.
	    int terminator = RB - LB;
	    // Must use iterator for switching squares within the same TOP, BOT, LB, RB boundaries
	    for (int i = 0; i < terminator; i++) {
		// Save top-left corner of square/matrix in a temporary variable so we can switch arounds elements
		// topLeft column index is calculated as LB + i because this corner moves laterally from left to right
		int topLeft = matrix[TOP][LB + i];
		// Move bottom-left into top-left --> topLeft = botLeft
		//   (a) topLeft has column index calculated as LB + i because this corner moves laterally from L->R
		//   (b) botLeft has row index calculated as BOT - i because this corner moves vertically from T<-B
		matrix[TOP][LB + i] = matrix[BOT - i][LB];
		// Move bottom-right into bottom-left --> botLeft = botRight
		//   (a) botLeft has row index calculated as BOT - i because this corner moves vertically from T<-B
		//   (b) botRight has column index calculated as RB - i because this corner moves laterally from L<-R
		matrix[BOT - i][LB] = matrix[BOT][RB - i];
		// Move top-right into bottom-right --> botRight - topRight
		//   (a) botRight column index calculated as RB - i because this corner moves laterally from L<-R
		//   (b) topRight row index calculated as TOP + i because this corner moves vertically from T->B
		matrix[BOT][RB - i] = matrix[TOP + i][RB];
		// Move top-left into top-right --> topRight = topLeft
		//   (a) topRight row index calcuated as TOP + i because this corner moves vertically from T->B
		//   (b) topLeft was stored in a temporary so we wouldn't use a temporary variable for each swap
		matrix[TOP + i][RB] = topLeft;
	    }
	    // Cinch up the sides by making the left and right boundaries both get closer to each other
	    LB++;
	    RB--;
	}
	printMatrix(matrix);
	out.println("Exiting rotate\n\n");
    }

    /**
     * Same as above, but it uses two <code>for</code> loops instead of a while loop and a <code>for</code> loop.
     */
    public static void rotateTwoForLoops(int[][] matrix) {
	for (int LB = 0, RB = matrix.length - 1; LB < RB; LB++, RB--) {
	    int TOP = LB;
	    int BOT = RB;
	    int termDist = RB - LB;
	    for (int i = 0; i < termDist; i++) {
		int topLeft = matrix[TOP][LB + i];
		matrix[TOP][LB + i] = matrix[BOT - i][LB]; // top-left corner moves from  LB  -> RB
		matrix[BOT - i][LB] = matrix[BOT][RB - i]; // bot-left corner moves from  TOP <- BOT
		matrix[BOT][RB - i] = matrix[TOP + i][RB]; // bot-right corner moves from LB  <- RB
		matrix[TOP + i][RB] = topLeft;             // top-right corner moves from TOP -> BOT
	    }
	}
    }

    public static void printMatrix(int[][] m) {
	StringBuilder result = new StringBuilder();
	result.append('[');
	for (int row = 0; row < m.length - 1; row++) {
	    result.append('[');
	    for (int col = 0; col < m.length - 1; col++) {
		result.append(m[row][col]).append(", ");
	    }
	    result.append(m[row][m.length - 1]).append(']').append("\n");
	}
	result.append('[');
        for (int i = 0; i < m.length - 1; i++) {
	    result.append(m[m.length - 1][i]).append(", ");
	}
	result.append(m[m.length - 1][m.length - 1]);
	result.append(']').append(']').append("\n");
	out.println(result.toString());
    }

    public static void main(String[] args) {
	for (int i = 0; i < 2; i++) {
	    int[][] m = Arrays.copyOf(allMatrices[i], allMatrices[i].length);
	    int[][] r = allMatrices[i + 2];
	    rotate(m);
	    printMatrix(m);
	    printMatrix(r);
	}
    }
}
