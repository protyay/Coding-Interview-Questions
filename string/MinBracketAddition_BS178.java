import java.util.*;

public class MinBracketAddition_BS178 {
    public int solve(String s) {
        if (s.isEmpty())
            return 0;
        Deque<Character> ch = new ArrayDeque<>();
        int ub = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
            case ')':
                if (!ch.isEmpty() && ch.getFirst() == '(')
                    ch.removeFirst();
                else
                    ++ub;
                break;
            case '(':
                ch.addFirst(c);
                break;
            }
        }
        return ch.size() + ub;
    }

}
