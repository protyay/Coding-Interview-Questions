import java.util.Set;

// SDE problem.
public class MinRemoveParenthesis_LC1249 {

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.isBlank())
            return s;
        StringBuilder str = new StringBuilder();
        int open = 0;

        final char OPEN = '(';
        Set<Character> parens = Set.of('(', ')');
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!parens.contains(curr))
                str.append(curr);
            else if (curr == OPEN) {
                str.append(curr);
                open++;
            } else {
                if (open > 0) {
                    open--;
                    str.append(curr);
                }
            }
        }

        int close = 0;
        final char CLOSE = ')';
        s = str.toString();
        str = new StringBuilder(); // We reuse the string builder reference

        for (int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);
            if (!parens.contains(curr))
                str.append(curr);
            else if (curr == CLOSE) {
                close++;
                str.append(curr);
            } else {
                if (close > 0) {
                    close--;
                    str.append(curr);
                }
            }
        }
        return str.reverse().toString();
    }
}
