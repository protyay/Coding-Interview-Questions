public class PopulatingNxtRightPointers_LC116 {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node start = root;
        while (start != null) {
            Node temp = start;
            while (temp != null) {
                if (temp.left != null)
                    temp.left.next = temp.right;
                if (temp.right != null && temp.next != null)
                    temp.right.next = temp.next.left;

                temp = temp.next;
            }
            start = start.left;// we go to the leftmost node at each level and follow the pointers
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
