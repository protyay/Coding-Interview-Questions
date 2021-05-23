import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackusing2Q_LC225 {
    /** Initialize your data structure here. */
    private final Deque<Integer> qA;
    private final Deque<Integer> qB;
    private int top = -1;

    public ImplementStackusing2Q_LC225() {
        // When i'm adding to to stack, I add to qA
        // When I'm removing from stack, I copy all elements to qB
        // remove from qA and add back to qA from qB
        this.qA = new ArrayDeque<>();
        this.qB = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.top = x;
        this.qA.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // You need to copy all the elements from qA to qB except 1(the TOP)
        while (qA.size() > 1) {
            qB.addLast(qA.removeFirst());
        }
        int top = qA.removeFirst();
        // Copy back all elements to qA
        while (!qB.isEmpty()) {
            this.qA.addLast(this.qB.removeFirst());
        }
        return top;
    }

    /** Get the top element. */
    public int top() {
        Iterator<Integer> revIterator = qA.descendingIterator();
        return revIterator.next();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.qA.isEmpty();
    }
}
