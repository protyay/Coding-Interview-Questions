import java.util.*;

public class ValidParentheses_LC22 {
    public List<String> generateParenthesis(int n) {
        if (n == 1)
            return List.of("()");
        List<String> ps = new ArrayList<>();
        dfs(n, "", ps, n, n);
        return ps;
    }

    private void dfs(int n, String temp, List<String> res, int o, int c) {
        if (o == 0 && c == 0) {
            res.add(temp);
            return;
        }
        if (o == c)
            dfs(n, temp + "(", res, o - 1, c);
        else if (o < c)
            if (o > 0)
                dfs(n, temp + "(", res, o - 1, c);
        if (c > 0)
            dfs(n, temp + ")", res, o, c - 1);
    }
}
