import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
// SDE problem.
public class MinRemoveParenthesis_LC1249 {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.isEmpty())
            return s;
        Deque<ArrayEntry> stack = new ArrayDeque<>();
        Set<Integer> invalidIndex = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currCh = s.charAt(i);
            if (Character.isAlphabetic(currCh))
                continue;
            if (currCh == '(') {
                stack.addFirst(new ArrayEntry(currCh, i));
            } else {
                if (!stack.isEmpty() && stack.getFirst().ch == '(') {
                    stack.removeFirst();
                } else {
                    invalidIndex.add(i);
                }
            }
        }
        // Pop all the elements from the stack and the index
        while (!stack.isEmpty()) {
            invalidIndex.add(stack.removeFirst().arrIndex);
        }
        if (invalidIndex.isEmpty())
            return s;
        StringBuilder validStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (invalidIndex.contains(i))
                continue;
            validStr.append(s.charAt(i));
        }
        return validStr.toString();
    }
}

class ArrayEntry {
    final char ch;
    final int arrIndex;

    ArrayEntry(char ch, int arrIndex) {
        this.ch = ch;
        this.arrIndex = arrIndex;
    }
}
