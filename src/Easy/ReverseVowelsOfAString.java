package Easy;


import java.util.ArrayList;
import java.util.Arrays;

public class ReverseVowelsOfAString {

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
        || c == 'U';
    }

    public String resverseVowels(String s) {
        char[] result = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i != j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (isVowel(l) && isVowel(r)) {
                result[i++] = r;
                result[j--] = l;
            } else if (isVowel(l)) {
                result[j--] = r;
            } else if (isVowel(r)) {
                result[i++] = l;
            }
        }
        return new String(result);
    }
}
