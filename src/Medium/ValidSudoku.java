package Medium;

import java.util.*;

public class ValidSudoku {

    static char[][] board1 = {
             {'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};

    static char[][] board2 = {
             {'8','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
    
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = (int) Math.sqrt(n);
        Set<Character>[] rowSet = new Set[n];
        Set<Character>[] colSet = new Set[n];
        Set<Character>[][] cubeGroup = new Set[m][m];
        // Instantiate the HashSet for each row and column
        for (int i = 0; i < n; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }
        // Instantiate the cubeGroup
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cubeGroup[i][j] = new HashSet<>();
            }
        }
        // Populate the sets for each column and row
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            char[] row = board[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                char c = row[colIndex];
                if (!Character.isDigit(c)) {
                    continue;
                }
                Set<Character> rs = rowSet[rowIndex];
                Set<Character> cs = colSet[colIndex];
                int cgRowIndex = rowIndex / m;
                int cgColIndex = colIndex / m;
                Set<Character> cgs = cubeGroup[cgRowIndex][cgColIndex];
                if (rs.contains(c) || cs.contains(c) || cgs.contains(c)) {
                    return false;
                }
                rs.add(c);                        // Update the rowSet with a char from the given row
                cs.add(c);                        // Update the colSet with a char from the given column
                cgs.add(c);                       // Update the cubeGroup with a char in that group
            }
        }
        return true;
    }

    public static String nestedArrPrinter(char[][] arr) {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int i = 0; i < arr.length; i++) {
            char[] a = arr[i];
            result.append(Arrays.toString(a));
            if (i != arr.length - 1) {
                result.append('\n');
            }
        }
        result.append('}');
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.printf("isValidSudoku(%n%s) -> %b%n",
                nestedArrPrinter(board1),
                isValidSudoku(board1));
        System.out.printf("isValidSudoku(%n%s) -> %b%n",
                nestedArrPrinter(board2),
                isValidSudoku(board2));
    }
}
