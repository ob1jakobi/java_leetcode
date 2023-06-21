package Easy;

import java.util.HashMap;

public class ValidAnagrams {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        for (char c: t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else if (map.get(c) > 1) {
                map.merge(c, -1, Integer::sum);
            } else {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

    public static boolean altIsAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
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
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";

        String s3 = "rat";
        String s4 = "car";

        print(s1, s2);
        print(s3, s4);
    }

    public static void print(String s1, String s2) {
        System.out.printf("s1:\t%s%ns2:\t%s%nisAnagram:\t%b%n%n", s1, s2, isAnagram(s1, s2));
    }
}
