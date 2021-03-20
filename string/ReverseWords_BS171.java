import java.util.*;
/**
 * One of the few String quirky questions. When you split by a single string, it covers
 * all the leading spaces in the array, you need to manually add the trailing spaces
 */
public class ReverseWords_BS171 {
    public String solve(String sentence) {
        StringBuilder str = new StringBuilder();
        String[] words = sentence.split(" ");
        System.out.println(Arrays.toString(words));
        int endIndex = sentence.length() - 1;
        while (endIndex >= 0 && sentence.charAt(endIndex) == 32) {
            str.append(" ");
            --endIndex;
        }
        for (int i = words.length - 1; i >= 0; i--) {
            str.append(words[i]);
            if (i > 0)
                str.append(" ");
        }

        return str.toString();
    }
}
