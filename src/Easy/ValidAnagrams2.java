

public class ValidAnagrams2 {

    public static boolean isAnagram(String s, String t) {
	if (s.length() != t.length()) {
	    return false;
	}
        int[] alphabet = new int[26];
	for (int i = 0; i < s.length(); i++) {
	    alphabet[s.charAt(i) - 'a']++;
	    alphabet[t.charAt(i) - 'a']--;
	}
	for (int count: alphabet) {
	    if (count != 0) {
		return false;
	    }
	}
	return true;
    }

    public static void main (String[] args) {
	String s1 = "anagram";
	String s2 = "nagaram";

	String s3 = "rat";
	String s4 = "car";

	String[] all_strs = {s1, s2, s3, s4};
	for (String s_1: all_strs) {
	    for (String s_2: all_strs) {
		System.out.printf("s1:\t%s%ns2:\t%s%nisAnagram(s1, s2):\t%b%n",
				  s_1,
				  s_2,
				  isAnagram(s_1, s_2));
	    }
	}
    }
}
