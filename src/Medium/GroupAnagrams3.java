import java.util.*;

public class GroupAnagrams3 {
    public static List<List<String>> groupAnagrams(String[] strs) {
	if (strs.length == 0) {
	    return new ArrayList<>();
	}
	HashMap<Integer, List<String>> map = new HashMap<>();
	for (String s: strs) {
	    int[] letterCounts = new int[26];
	    for (char c: s.toCharArray()) {
		letterCounts[c - 'a']++;
	    }
	    int hashKey = Arrays.hashCode(letterCounts);
	    map.computeIfAbsent(hashKey, (key) -> new ArrayList<>());
	    map.get(hashKey).add(s);
	}
	return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
	String[] strs2 = {""};
	String[] strs3 = {"a"};

	String[][] all_strs = {strs1, strs2, strs3};
	for (String[] strs: all_strs) {
	    System.out.printf("groupAnagrams(%s) -> %s%n",
			      Arrays.toString(strs),
			      groupAnagrams(strs));
	}
    }
}
