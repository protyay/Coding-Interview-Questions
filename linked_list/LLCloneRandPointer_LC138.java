import java.util.HashMap;
import java.util.Map;

//SDE Repeat
public class LLCloneRandPointer_LC138 {
    // Space complexity of O(N)
    // We need the visitedMap due to the presence of random pointers
    // Random pointers MIGHT introduce LL cycles and we should be careful to NOT
    // create
    // redundant new NODES
    private final Map<Node, Node> visitedMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node copyHead = new Node(-10001);
        Node temp = copyHead;

        if (head == null)
            return null;
        // O(N) solution
        while (head != null) {
            Node newNode = this.clone(head);
            newNode.random = this.clone(head.random);
            newNode.next = this.clone(head.next);

            head = head.next;
            temp.next = newNode;

            temp = temp.next;
        }
        return copyHead.next;
    }

    private Node clone(Node oldNode) {
        if (oldNode == null)
            return null;

        if (!this.visitedMap.containsKey(oldNode)) {
            this.visitedMap.put(oldNode, new Node(oldNode.val));
        }
        return this.visitedMap.get(oldNode);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
// SDE repeat - Without hashmap - Constant space
class LLCloneWithConstantSpace {
    public Node copyRandomList(Node head) {
        // O(1) solution
        if (head == null)
            return null;

        Node oldHead = head;
        Node oldHeadA = head;

        // 1. We weave new copy nodes in-between old Nodes
        while (head != null) {

            Node temp = head.next;
            Node copyNode = new Node(head.val);
            copyNode.next = temp;
            head.next = copyNode;

            head = temp;
        }
        // 2. We iterate the LL from the front and point the random pointers
        while (oldHead != null && oldHead.next != null) {
            Node temp = oldHead.next.next;

            if (oldHead.random != null)
                oldHead.next.random = oldHead.random.next;

            oldHead = temp;
        }
        // 3. Restore the original LL and return new LL
        Node copyHead = new Node(-10001);
        Node dummyCopyHead = copyHead;

        while (oldHeadA != null && oldHeadA.next != null) {
            Node temp = oldHeadA.next.next;
            copyHead.next = oldHeadA.next;
            // Restore the original LL
            oldHeadA.next = temp;

            copyHead = copyHead.next;
            oldHeadA = oldHeadA.next;
        }
        return dummyCopyHead.next;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
