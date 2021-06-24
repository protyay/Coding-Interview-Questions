import java.util.*;

public class MobileNumLetter_LC17 {
    String[] map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isBlank())
            return ans;
        combine(digits, 0, "");
        return ans;
    }

    private void combine(String digits, int index, String temp) {
        if (index == digits.length()) {
            ans.add(temp);
            return;
        }
        String str = map[digits.charAt(index) - '0' - 2];
        for (int i = 0; i < str.length(); i++) {
            combine(digits, index + 1, temp + str.charAt(i));
        }
    }

}
