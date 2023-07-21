


public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
	char[] arr = s.toCharArray();
	int l = 0;
	int r = arr.length - 1;
	while (l < r) {
	    char lChar = Character.toUpperCase(arr[l]);
	    char rChar = Character.toUpperCase(arr[r]);
	    if (!Character.isLetterOrDigit(lChar)) {
		l++;
		continue;
	    }
	    if (!Character.isLetterOrDigit(rChar)) {
		r--;
		continue;
	    }
	    if (lChar != rChar) {
		return false;
	    } else {
		l++;
		r--;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	
    }
}
