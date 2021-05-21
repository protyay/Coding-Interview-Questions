import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveConsecutiveDupII_LC1209 {
    // SDE Repeat
    public String removeDuplicates(String s, int k) {
        if (s == null || s.isBlank() || s.length() == 1)
            return s;
        // abcd
        // deeedbbcccbdaa
        Deque<ArrEle> stack = new ArrayDeque<>();
        stack.addFirst(new ArrEle(1, s.charAt(0)));
        int prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                ArrEle old = stack.removeFirst();
                old.count++;
                // If the updated count is less than K, we insert it into the
                // stack. Else, we ignore
                if (old.count < k) {
                    stack.addFirst(old);
                }
            } else {
                stack.addFirst(new ArrEle(1, curr));
            }
            prev = stack.isEmpty() ? ' ' : stack.getFirst().c;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ArrEle element = stack.removeLast();
            while (element.count-- > 0)
                ans.append(element.c);
        }
        return ans.toString();
    }
}

class ArrEle {
    int count;
    char c;

    ArrEle(int count, char c) {
        this.count = count;
        this.c = c;
    }
}
