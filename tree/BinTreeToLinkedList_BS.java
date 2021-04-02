import java.util.ArrayDeque;
import java.util.Deque;

public class BinTreeToLinkedList_BS {
    public LLNode solve(Tree root) {
        if (root == null)
            return null;
        Deque<Tree> stack = new ArrayDeque<>();

        LLNode head = new LLNode();
        LLNode ans = head;
        fillNodes(root, stack);

        while (!stack.isEmpty()) {
            // Pop from the stack
            Tree top = stack.removeFirst();
            // Create a new node with the element
            LLNode nextNode = new LLNode();
            nextNode.val = top.val;
            ans.next = nextNode;
            // Fill the stack with next nodes
            fillNodes(top.right, stack);

            ans = ans.next;
        }
        return head.next;
    }

    private void fillNodes(Tree root, Deque<Tree> stack) {
        while (root != null) {
            stack.addFirst(root);
            root = root.left;
        }
    }
}
