import java.util.List;
import java.util.ArrayList;


/**
 * Give an integer <code>numRows</code>, return the first <code>numRows</code> of <strong>Pascal's Triangle
 * </strong>.<br>
 * In <strong>Pascal's Triangle</strong>, each number is the sum of the two numbers directly above it.<br><br>
 *
 * Constraints:
 * <ul>
 *    <li>1 &le numRows &le 30</li>
 * </ul>
 */
public class PascalsTriangle {

    /**
     * This implementation uses an iterative solution, instead of a recurisve solution. The <code>for</code>
     * loop iterates up to the number of rows passed by the parameter <code>numRows</code>. For each iteration,
     * the <code>row</code> variable will be instantiated to be a new <code>ArrayList</code> instance, since
     * each iteration will add a new <code>List</code> to the <code>result</code>.<br><br>
     *
     * The <code>switch</code> statement determines how the <code>row</code> will be built, which is based
     * on 1 of 3 scenarios:
     * <ul>
     *    <li>`result` is empty, so we have to build up the nested singleton.</li>
     *    <li>`result` already contains the nested singleton, so we need to build the 2nd row.</li>
     *    <li>`result` has enough rows built so that we can build up the current row based on the
     *         contents of the previous row.</li>
     * </ul>
     *
     * In the <code>default switch</code> condition, we first establish the first and last elements of the
     * row, which will always be <code>1</code>. After building up the boundaries, we then initialize the
     * variable <code>j</code> for iterating over the elements in the previous row starting at the second
     * index position, <code>1</code>. The <code>while</code> loop allows us to iterate over the contents
     * of the previous row. Since the number that will be added to the current row is the sum of the element
     * that immediately preceeds it's respective index in the previous row, as well as the index of the element
     * at the same index in the previous row, we initialize variables <code>numPrev2</code> and <code>
     * numPrev1</code> to these values, respectively. This sum is saved in the variable <code>num</code>,
     * which is added to the current <code>row</code> while incrementing the index of <code>j</code>, our
     * iterator.<br><br>
     *
     * Once the <code>while</code> loop has completed, all of the elements have been added to the next
     * row that will be appended to <code>result</code>, which occurs after the scope of all of the
     * <code>switch</code> conditions. When we've iterated up to <code>numRows</code>, then we return
     * the <code>result</code>.
     */
    public static List<List<Integer>> generate(int numRows) {
	int i, j, num, numPrev1, numPrev2;
	List<Integer> row;
	List<List<Integer>> result;
	
	result = new ArrayList<>();
	
        for (i = 0; i < numRows; i++) {
	    row = new ArrayList<>();
	    switch (result.size()) {
	    case 0:
		row.add(1);
		break;
	    case 1:
		row.add(1);
		row.add(1);
		break;
	    default:
		row.add(1);
		row.add(1);
		j = 1; 
		while (j < result.get(i - 1).size()) {
		    numPrev2 = result.get(i - 1).get(j - 1);
		    numPrev1 = result.get(i - 1).get(j);
		    num = numPrev2 + numPrev1;
		    row.add(j++, num);
		}
		break;
	    }
	    result.add(row);
	}
	return result;
    }

    public static void main(String[] args) {
	for (int i = 1; i <= 10; i++) {
	    System.out.println(generate(i));
	}
    }
}
