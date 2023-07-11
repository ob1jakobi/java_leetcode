public class ValidPalindrome {

    /**
     * According to the rules, only alphanumeric characters are valid; special characters and
     * whitespace should be ignored.
     */
    public static boolean isValid(char c) {
	return Character.isDigit(c) || Character.isAlphabetic(c);
    }

    /**
     * Two-pointer solution to ValidPalindrome. Since a palindrome is the same forwards as it
     * reversed, the pointer that advances from the left-most position should exactly match
     * the character at the pointer that moves from the right-most position towards the start.
     * This skips over the whitespace and non-valid characters, and only returns true IFF
     * all <em>valid</em> characters mirrored.
     */
    public static boolean isPalindrome(String s) {
	int l = 0;
	int r = s.length() - 1;
	char lChar;
	char rChar;
	while (l < r) {
	    lChar = Character.toLowerCase(s.charAt(l));
	    rChar = Character.toLowerCase(s.charAt(r));
	    if (isValid(lChar) && isValid(rChar)) {
		if (lChar == rChar) {
		    l++;
		    r--;
		    continue;
		} else {
		    return false;
		}
	    }
	    if (!isValid(lChar)) {
		l++;
	    }
	    if (!isValid(rChar)) {
		r--;
	    }
	}
	return true;
    }
}
