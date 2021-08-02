import java.util.ArrayList;
import java.util.List;

public class PallindromePart_LC131 {
    // SDE Repeat
    final List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.isBlank())
            return ans;
        final List<String> temp = new ArrayList<>();
        dfs(s, 0, temp);
        return ans;
    }

    private void dfs(String s, int currIndex, List<String> temp) {
        if (s.length() == currIndex) {
            if (temp.size() > 0)
                ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = currIndex; i < s.length(); i++) {
            if (isPal(s, currIndex, i)) {
                temp.add(s.substring(currIndex, i + 1));
                dfs(s, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int from, int to) {
        if (from == to)
            return true;
        while (from < to) {
            if (s.charAt(from) != s.charAt(to))
                return false;
            from++;
            to--;
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
