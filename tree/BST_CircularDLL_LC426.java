import java.util.ArrayDeque;
import java.util.Deque;

public class BST_CircularDLL_LC426 {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        Node head = null, tail = null;

        Deque<Node> stack = new ArrayDeque<>();
        fillNode(stack, root);

        while (!stack.isEmpty()) {
            Node top = stack.removeFirst();
            if (tail == null)
                head = top;
            else {
                tail.right = top;
                top.left = tail;
            }
            tail = top;
            fillNode(stack, top.right);
        }
        tail.right = head;
        head.left = tail;

        return head;
    }

    private void fillNode(Deque<Node> stack, Node root) {
        while (root != null) {
            stack.addFirst(root);
            root = root.left;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
