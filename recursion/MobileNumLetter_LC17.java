import java.util.*;

public class MobileNumLetter_LC17 {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return List.of();
        Map<Character, String> keyCharMap = new HashMap<>();

        keyCharMap.put('2', "abc");
        keyCharMap.put('3', "def");
        keyCharMap.put('4', "ghi");
        keyCharMap.put('5', "jkl");
        keyCharMap.put('6', "mno");
        keyCharMap.put('7', "pqrs");
        keyCharMap.put('8', "tuv");
        keyCharMap.put('9', "wxyz");

        char[] ch = digits.toCharArray();
        List<String> res = new ArrayList<>();
        recurse(ch, keyCharMap, new StringBuilder(), res, 0);

        return res;
    }

    private void recurse(char[] digits, Map<Character, String> keyMap, StringBuilder tmp, List<String> rec, int index) {
        if (tmp.length() == digits.length) {
            rec.add(tmp.toString());
            return;
        }

        String chars = keyMap.get(digits[index]);
        for (char c : chars.toCharArray()) {
            tmp.append(c);
            recurse(digits, keyMap, tmp, rec, index + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

}
