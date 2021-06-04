public class FlatteningLL_GFGSDE {
    // SDE problem
    Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;
        Node last = flatten(root.next);

        Node temp = new Node(0);
        Node res = temp;
        Node tempLast = root;
        while (root != null && last != null) {
            if (root.data < last.data) {
                temp.bottom = root;
                root = root.bottom;
            } else {
                temp.bottom = last;
                last = last.bottom;
            }
            temp = temp.bottom;
        }
        if (root != null) {
            temp.bottom = root;
        } else {
            temp.bottom = last;
        }

        if (tempLast != null)
            tempLast.next = null;
        return res.bottom;
    }

    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }
}
