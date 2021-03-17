import java.util.*;

public class GroupAnagram_LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1)
            return List.of(List.of(strs[0]));
        Map<String, List<String>> group = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String curr = strs[i];
            int[] ch = new int[26];
            for (int k = 0; k < curr.length(); k++) {
                ch[curr.charAt(k) - 'a']++;
            }
            StringBuilder strBuilder = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                strBuilder.append('#');
                strBuilder.append(ch[k]);
            }
            String key = strBuilder.toString();
            group.computeIfAbsent(key, a -> new ArrayList<String>());
            group.get(key).add(curr);
        }

        return new ArrayList<>(group.values());
    }

    public static void main(String[] args) {
        String[] arr = { "eat", "tea", "tan", "ate", "nat", "bat" };
        GroupAnagram_LC49 lc = new GroupAnagram_LC49();
        List<List<String>> groupAnagrams = lc.groupAnagrams(arr);
        System.out.println(groupAnagrams);
    }
}
