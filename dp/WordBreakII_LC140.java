import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakII_LC140 {
    private List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isBlank())
            return ans;
        dfs(s, 0, new HashSet<>(wordDict), new ArrayList<String>());
        return ans;
    }

    private void dfs(String s, int index, Set<String> dict, List<String> temp) {
        if (index == s.length()) {
            if (!temp.isEmpty())
                ans.add(temp.stream().collect(Collectors.joining(" ")));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(c);
            if (!dict.contains(stringBuilder.toString()))
                continue;
            temp.add(stringBuilder.toString());
            dfs(s, i + 1, dict, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        String input = "catsanddoganddogandc";
        List<String> allsubStr = new ArrayList<>();
        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j < i; j++) {
                allsubStr.add("\"" + input.substring(j, i) + "\"");
            }
        }
        System.out.println(allsubStr);
    }
}
