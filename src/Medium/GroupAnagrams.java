package Medium;

import java.util.*;

public class GroupAnagrams {
    final int N_LETTERS = 26;

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> result = new HashMap<>();
        int[] count;
        for (String s: strs) {
            count = new int[26];
            for (char c: s.toCharArray()) {
                count[c - 'a']++;
            }
            int hash = Arrays.hashCode(count);
            // The below commented code does the same thing as the un-commented code
            //result.computeIfAbsent(hash, key -> new ArrayList<>());
            //result.get(hash).add(s);
            result.merge(hash, List.of(s), (currList, newList) -> {
                List<String> mergedList = new ArrayList<>(currList);
                mergedList.addAll(newList);
                return mergedList;
            });
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};

        List<List<String>> res1 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList("bat")),
                        new ArrayList<>(Arrays.asList("nat", "tan")),
                        new ArrayList<>(Arrays.asList("ate", "eat", "tea"))
                )
        );

        List<List<String>> res2 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(""))
                )
        );

        List<List<String>> res3 = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList("a"))
                )
        );

        System.out.println(groupAnagrams(strs1));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));

        int[] test1 = new int[] {1, 0 , 1};
        int[] test2 = new int[] {1, 0 , 1};

        int hash1 = Arrays.hashCode(test1);
        int hash2 = Arrays.hashCode(test2);

        System.out.printf("hash1:\t%d%nhash2:\t%d%n", hash1, hash2);
    }
}
