import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQusing2Stacks_LC169 {
    /** Initialize your data structure here. */
    private final Deque<Integer> pushStack;
    // The idea is to treat pushStack TOP as the BACK of the Q
    private final Deque<Integer> peekStack;

    // The TOP of the peek stack is FRONT of the Q
    public ImplementQusing2Stacks_LC169() {
        this.pushStack = new ArrayDeque<>();
        this.peekStack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.pushStack.addFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (this.peekStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                this.peekStack.addFirst(this.pushStack.removeFirst());
            }
        }
        return this.peekStack.removeFirst();
    }

    /** Get the front element. */
    public int peek() {
        if (this.peekStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                this.peekStack.addFirst(this.pushStack.removeFirst());
            }
        }
        return this.peekStack.getFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.pushStack.isEmpty() && this.peekStack.isEmpty();
    }
}
/**
 * Use 
 */
