import java.util.*;
import java.util.stream.Collectors;

public class MagicDict_LC676 {
    /** Initialize your data structure here. */
    Set<String> dict = null;

    public MagicDict_LC676() {

    }

    public void buildDict(String[] dictionary) {
        dict = Arrays.stream(dictionary).collect(Collectors.toSet());
    }

    public boolean search(String searchWord) {
        if (searchWord.isEmpty())
            return false;

        for (int i = 0; i < searchWord.length(); i++) {
            char[] ch = searchWord.toCharArray();
            for (int j = 0; j <= 25; j++) {
                ch[i] = (char) (97 + j);
                String s = String.valueOf(ch);
                if (dict.contains(s) && !s.equals(searchWord))
                    return true;
            }
        }
        return false;
    }

}
