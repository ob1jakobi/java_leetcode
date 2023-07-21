import static java.lang.System.out;
import java.util.HashMap;


/**
 * <p>Given two <code>Strings</code> `s` and `t`, return `true` <em>if `t` is an anagram
 * of `s`, and `false` otherwise</em>. An <strong>anagram</strong> is a word or phrase
 * formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.</p>
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
	if (s.length() != t.length()) {
	    return false;
	}
	int[] counts = new int['z' - 'a' + 1];
	for (int i = 0; i < s.length(); i++) {
	    counts[s.charAt(i) - 'a']++;
	    counts[t.charAt(i) - 'a']--;
	}
	for (int n: counts) {
	    if (n != 0) {
		return false;
	    }
	}
	return true;

	/* Works
	if (s.length() != t.length()) {
	    return false;
	}
	HashMap<Character, Integer> sCounts = new HashMap<>();
	HashMap<Character, Integer> tCounts = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
	    sCounts.merge(s.charAt(i), 1, Integer::sum);
	    tCounts.merge(t.charAt(i), 1, Integer::sum);
	}
	for (char c: s.toCharArray()) {
	    if (!tCounts.containsKey(c)) {
		return false;
	    }
	}
	return true;
	*/
    }

    public static void main(String[] args) {
	String s1 = "anagram";
	String s2 = "nagaram";
	String s3 = "rat";
	String s4 = "car";
	String s5 = "racecar";
	String s6 = s3 + s4;

	String[] ss = {s1, s2, s3, s4, s5, s6};
	for (String s: ss) {
	    for (String t: ss) {
		boolean r = isAnagram(s, t);
		out.printf("s:\t%s\nt:\t%s\nr:\t%b\n\n",
			   s,
			   t,
			   r);
	    }
	}
    }
}
