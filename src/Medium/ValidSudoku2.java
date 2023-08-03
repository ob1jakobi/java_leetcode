import static java.lang.System.out;
import java.util.Arrays;
import java.util.HashSet;


public class ValidSudoku2 {

    public static boolean isValidSudoku(char[][] board) {
	boolean isBadRow, isBadCol, isBadSubSqr;
	int i, j, rowIndex, colIndex, sRow, sCol;
	int colAndRowLen = board.length;
	int subSquareLen = (int) Math.sqrt(colAndRowLen);

	char item;
	char[] row;
	
	HashSet<Character>[] rows = new HashSet[colAndRowLen];
	HashSet<Character>[] cols = new HashSet[colAndRowLen];
	HashSet<Character>[][] subSquare = new HashSet[subSquareLen][subSquareLen];

	// Initialize the rows and columns sets
	for (i = 0; i < colAndRowLen; i++) {
	    rows[i] = new HashSet<>();
	    cols[i] = new HashSet<>();
	}
	// Initialize the subsquares
	for (i = 0; i < subSquareLen; i++) {
	    for (j = 0; j < subSquareLen; j++) {
		subSquare[i][j] = new HashSet<>();
	    }
	}

	for (rowIndex = 0; rowIndex < colAndRowLen; rowIndex++) {
	    row = board[rowIndex];
	    for (colIndex = 0; colIndex < colAndRowLen; colIndex++) {
		item = row[colIndex];
		if (item == '.') {
		    continue;
		}
		sRow = rowIndex / subSquareLen;
		sCol = colIndex / subSquareLen;
		isBadRow = rows[rowIndex].contains(item);
		isBadCol = cols[colIndex].contains(item);
		isBadSubSqr = subSquare[sRow][sCol].contains(item);
		if (isBadRow || isBadCol || isBadSubSqr) {
		    return false;
		}
		rows[rowIndex].add(item);
		cols[colIndex].add(item);
		subSquare[sRow][sCol].add(item);
	    }
	}
	return true;
    }


    public static void main(String[] args) {
	char[][] board1 =
	    {
		{'5','3','.','.','7','.','.','.','.'},
		{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'}
	    };
	char[][] board2 =
	    {
		{'8','3','.','.','7','.','.','.','.'},
		{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'}
	    };

	for (int i = 0; i < 2; i++) {
	    char[][] board = i == 0 ? board1 : board2;
	    boolean result = isValidSudoku(board);
	    out.println("board:");
	    for (char[] row: board) {
		out.printf("\t\t%s\n", Arrays.toString(row));
	    }
	    out.printf("result:\t\t%b\n", result);
	    out.printf("correct:\t%b\n\n", i == 0);
	}
    }
}
