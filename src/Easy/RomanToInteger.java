import java.util.Map;


/**
 * Roman numeral are represented by seven different symbols:<br>
 * <ul>
 *    <li>Symbol     Value</li>
 *    <li>I          1</li>
 *    <li>V          5</li>
 *    <li>X          10</li>
 *    <li>L          50</li>
 *    <li>C          100</li>
 *    <li>D          500</li>
 *    <li>M          1000</li>
 * </ul>
 *
 * For example, <code>2</code> is written <code>II</code> in Roman numeral, just two ones added together.
 * <code>12</code> is written as <code>XII</code>, which is simple <code>X + II</code>. The number
 * <code>27</code> is written as <code>XXVII</code>, which is <code>XX + V + II</code>.<br>
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four
 * is not <code>IIII</code> - it is written <code>IV</code>, because the one is before the five, we subtract
 * it making four.  The same principle applies to the number nine, which is written as <code>IX</code>.<br>
 *
 * There are six instances where subtraction is used:
 * <ul>
 *    <li>`I` can be placed before `V` (5) and `X` (10) to make 4 and 9.</li>
 *    <li>`X` can be placed before `L` (50) and `C` (100) to make 40 and 90.</li>
 *    <li>`C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.</li>
 * </ul>
 *
 * Given a Roman numeral, convert it to an integer.<br><br>
 *
 * Constraints:
 * <ul>
 *    <li>1 &le s.length &le 15</li>
 *    <li>`s` contains only the characters (`I`, `V`, `X`, `L`, `C`, `D`, `M`).</li>
 *    <li>It is guaranteed that `s` is a valid roman numeral in the range `[1, 3999]`.</li>
 * </ul>
 */
public class RomanToInteger {

    static final Map<Character, Integer> romanInts = Map.of(
							    'I', 1,
							    'V', 5,
							    'X', 10,
							    'L', 50,
							    'C', 100,
							    'D', 500,
							    'M', 1000);

    /* Code from LeetCode's editorial
    public static int romanToInt(String s) {
	char c;
	int result, prevNum, currNum, i;

	result = 0;
	prevNum = 0;

	for (i = s.length() - 1; i >= 0; i--) {
	    c = s.charAt(i);
	    currNum = romanInts.get(c);

	    if (currNum < prevNum) {
		result -= currNum;
	    } else {
		result += currNum;
	    }
	    prevNum = currNum;
	}
	return result;
    }
    */

    /**
     * This approach iterates over <code>s</code> from right-to-left to reach the appropriate solution.
     * The reason why the right-to-left approach is appropriate has to do with the possibility of a
     * value to decrease based on the character preceeding the currently iterated value. As we iterate
     * over <code>s</code>, we use variables to take a snapshot of the currently iterated character, (
     * <code>currChar</code>), the character immediately preceeding the currently iterated character (
     * <code>befrChar</code>), and the possible number that will be used to update the <code>result</code>
     * that will ultimately be returned (<code>num</code>).<br><br>
     *
     * With the snapshot obtained, we use a <code>switch</code> statement to check what our currently
     * iterated character is. If <code>currChar</code> is a character that may be decreased due to the
     * preceeding character (i.e., <code>befrChar</code>), then we subtract the appropriate amount from
     * <code>num</code>. IFF we do have to subtract from <code>num</code>, then we need to decrement the
     * pointer for <code>currChar</code>, since we've already taken the preceeding character's value into
     * account for updating <code>result</code>.<br><br>
     *
     * Because we're taking into account the preceeding character, the <code>while</code> loop should
     * only iterate while <code>i</code> is &gt <code>0</code>. It's possible that - during the
     * <code>while</code> loop iteration - we terminate the loop where <code>i == 0</code>, as would be the
     * case if <code>s</code> were <code>"IV"</code>. It's also possible that the <code>while</code> loop
     * would only decrement <code>i</code> once, as would be the case if <code>s</code> were <code>"VI"</code>.
     * This is why there's the final condition statement, to see if we need to capture that last character
     * so we can update <code>result</code> before returning from the function.
     */
    public static int romanToInt(String s) {
	Char currChar, befrChar;
	int result, num, i;

	result = 0;
        i = s.length() - 1;

	while (i > 0) {
	    currChar = s.charAt(i);
	    befrChar = s.charAt(i - 1);
	    num = romanInts.get(currChar);

	    switch (currChar) {
	    case 'V':
	    case 'X':
		if (befrChar == 'I') {
		    num -= romanInts.get(befrChar);
		    i--;
		}
		break;
	    case 'L':
	    case 'C':
		if (befrChar == 'X') {
		    num -= romanInts.get(befrChar);
		    i--;
		}
		break;
	    case 'D':
	    case 'M':
		if (befrChar == 'C') {
		    num -= romanInts.get(befrChar);
		    i--;
		}
		break;
	    default:
		break;
	    }
	    result += num;
	    i--;
	}

	if (i == 0) {
	    result += romanInts.get(s.charAt(i));
	}
	return result;
    }

    public static void main(String[] args) {
	String n1 = "III";        // 3
	String n2 = "LVIII";      // 58
	String n3 = "MCMXCIV";    // 1994
	String n4 = "IV";         // 4
	String n5 = "IX";         // 9
	String n6 = "XL";         // 40
	String n7 = "V";          // 5
	String n8 = "X";          // 10

	System.out.println("Roman Numeral\tInteger");
	System.out.println("-------------\t-------");
	String[] ns = {n1, n2, n3, n4, n5, n6, n7, n8};
	for (String n: ns) {
	    System.out.printf(" %s\t\t%d\n", n, romanToInt(n));
	}
    }
}
