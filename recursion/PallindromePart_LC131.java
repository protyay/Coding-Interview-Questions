import java.util.ArrayList;
import java.util.List;

public class PallindromePart_LC131 {
    // SDE Repeat
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        if (s == null || s.isBlank())
            return ans;

        dfs(s, new ArrayList<String>(), ans, 0);
        return ans;
    }

    private void dfs(String s, List<String> temp, List<List<String>> ans, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPal(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                dfs(s, temp, ans, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int lo, int hi) {
        while (lo <= hi) {
            if (s.charAt(lo++) != s.charAt(hi--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PallindromePart_LC131 lc131 = new PallindromePart_LC131();
        List<List<String>> partition = lc131.partition("aabc");
        System.out.println(partition);
    }
}
/**
 * Let's understand the time complexity
 */
