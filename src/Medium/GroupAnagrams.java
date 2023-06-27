package Medium;

import java.util.*;

public class GroupAnagrams {
    /**
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs));
        }
        final int N_ALPHABET = 26;
        HashMap<Integer, List<String>> countsMap = new HashMap<>();
        for (String word: strs) {
            int[] charCountArr = new int[N_ALPHABET];
            for (char c: word.toCharArray()) {
                charCountArr[c - 'a']++;
            }
            int countsKey = Arrays.hashCode(charCountArr);
            /*
            Much more efficient; if the key isn't in the map, then it creates a new ArrayList - however, regardless
            whether the key already exists, the word will be added to the list that will always be present
            at that stage.
             */
            countsMap.computeIfAbsent(countsKey, (key) -> new ArrayList<>());
            countsMap.get(countsKey).add(word);
            /* The below works, but is inefficient; if the list exists, then it re-creates the list just to add
            ** a new element to the list
            countsMap.merge(countsKey, List.of(word), (currentListForKey, newListForKey) -> {
                ArrayList<String> mergedList = new ArrayList<>(newListForKey);
                mergedList.addAll(currentListForKey);
                return mergedList;
            });
             */
        }
        return new ArrayList<>(countsMap.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};

        String[][] all_strs = {strs1, strs2, strs3};

        for (String[] strs: all_strs) {
            System.out.printf("strs:\t%s%ngroupAnagrams(strs):\t%s%n%n",
                    Arrays.toString(strs),
                    groupAnagrams(strs)
            );
        }
    }


    /*
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
            result.computeIfAbsent(hash, key -> new ArrayList<>());
            result.get(hash).add(s);
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
     */
}
