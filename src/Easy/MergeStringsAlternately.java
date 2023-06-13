package Easy;


public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        char[] result = new char[word1.length() + word2.length()];
        int i = 0, j = 0;
        do {
            if (i < word1.length()) {
                result[j++] = word1.charAt(i);
            }
            if (i < word2.length()) {
                result[j++] = word2.charAt(i);
            }
            i++;
        } while (i < word1.length() || i < word2.length());
        return new String(result);
    }
}
