import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack_BS {
    private Deque<StackEntry> stack;

    public MinStack_BS() {
        this.stack = new ArrayDeque<>();
    }

    public void append(int val) {
        int min = val;
        if (!stack.isEmpty()) {
            StackEntry topElement = stack.getFirst();
            min = Math.min(val, topElement.currMin);
        }
        StackEntry newEntry = new StackEntry(val, min);
        stack.addFirst(newEntry);
    }

    public int peek() {
        return stack.getFirst().entryValue;
    }

    public int min() {
        return stack.getFirst().currMin;
    }

    public int pop() {
        return stack.removeFirst().entryValue;
    }
}

class StackEntry {
    int entryValue;
    int currMin;

    public StackEntry(int val, int min) {
        this.entryValue = val;
        this.currMin = min;
    }

}
