import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParen_LC301 {
    private final Set<Character> parens = Set.of('(', ')');

    public List<String> removeInvalidParentheses(String s) {
        // BFS
        Deque<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        if (isValid(s))
            return List.of(s);
        q.addLast(s);
        visited.add(s);
        boolean validFound = false;
        Set<String> validSet = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.removeFirst();
                if (isValid(curr)) {
                    validSet.add(curr);
                    validFound = true;
                }
                if (validFound)
                    continue; // We don't need to explore any further edges

                // Decide next valid edges
                for (int i = 0; i < curr.length(); i++) {
                    if (!parens.contains(curr.charAt(i)))
                        continue;
                    String next = curr.substring(0, i) + curr.substring(i + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.addLast(next);
                    }
                }
            }
            if (validFound)
                break;
        }
        return new ArrayList<String>(validSet);
    }

    private boolean isValid(String s) {

        int left = 0;
        for (char c : s.toCharArray()) {
            if (!parens.contains(c))
                continue;
            if (c == '(')
                left++;
            else {
                if (left > 0)
                    left--;
                else
                    return false;
            }
        }
        return left == 0;
    }
}

/**
 * The BFS approach has a TC - O(n * n!). This is the most naive solution that
 * works and we are not doing any sort of optimizations
 */
class DFSWithPruning {
    private final List<String> list = new ArrayList<>();

    // DFS which only recurses on valid next states
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.isBlank())
            return list;

        dfs(s, 0, 0, new char[] { '(', ')' });
        return list;

    }

    private void dfs(String s, int lastRemoved, int start, char[] parens) {
        char[] ch = s.toCharArray();
        for (int i = 0, count = 0; i < ch.length; i++) {
            if (parens[0] == ch[i])
                count++;
            else if (parens[1] == ch[i])
                count--;

            if (count >= 0)
                continue;
            for (int j = lastRemoved; j <= i; j++) {
                if (ch[j] == parens[1] && (lastRemoved == j || ch[j - 1] != parens[1]))
                    dfs(s.substring(0, j) + s.substring(j + 1), j, i, parens);
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (parens[0] == '(')
            dfs(reversed, 0, 0, new char[] { ')', '(' });
        else
            list.add(reversed);
    }

    public static void main(String[] args) {
        String input = "()())()";
        DFSWithPruning dfs = new DFSWithPruning();
        List<String> validList = dfs.removeInvalidParentheses(input);
        System.out.println(validList);
    }
}