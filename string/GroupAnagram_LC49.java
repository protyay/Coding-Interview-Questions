import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram_LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return List.of(List.of());
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] hash = new int[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            // Calc the hash from the hash array
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                code.append(hash[i] * (i + 1));// While calc the hash function , it's important to assign
                // weightage to each count
            }
            map.computeIfAbsent(code.toString(), k -> new ArrayList<String>());
            map.get(code.toString()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] arr = { "bdddddddddd", "bbbbbbbbbbc" };
        GroupAnagram_LC49 lc = new GroupAnagram_LC49();
        List<List<String>> groupAnagrams = lc.groupAnagrams(arr);
        System.out.println(groupAnagrams);
    }
}
