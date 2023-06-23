package Medium;

import java.util.*;

public class GroupAnagrams2 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> my_map = new HashMap<>();
        for (String s: strs) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }
            int key = Arrays.hashCode(counts);
            my_map.merge(key, List.of(s), (currList, newList) -> {
                List<String> temp = new ArrayList<>(currList);
                temp.addAll(newList);
                return temp;
            });
        }
        return new ArrayList<>(my_map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};

        String[][] nested = {strs1, strs2, strs3};
        for (String[] arr: nested) {
            System.out.printf("strs: %s,\tgroupAnagrams(strs): %s%n", Arrays.toString(arr), groupAnagrams(arr));
        }
    }
}
