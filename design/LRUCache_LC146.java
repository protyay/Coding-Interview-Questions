import java.util.HashMap;
import java.util.Map;

// SDE problem
public class LRUCache_LC146 {
    private final Map<Integer, Node> cache;
    private final int size;
    private final Node head;
    private final Node tail;

    public LRUCache_LC146(int capacity) {
        this.cache = new HashMap<>();
        this.size = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node currNode = cache.get(key);
        this.remove(currNode);
        this.append(currNode);

        return currNode.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            this.remove(cache.get(key));
        } else if (cache.size() == this.size) {
            this.remove(head.next);
        }
        Node newNode = new Node(key, value);

        this.append(newNode);
    }

    // You append the recently acessed node to the end of the list
    private void append(Node currNode) {
        // Update the DLL
        tail.prev.next = currNode;
        currNode.next = tail;
        currNode.prev = tail.prev;
        tail.prev = currNode;

        this.cache.put(currNode.key, currNode);
    }

    private void remove(Node currNode) {
        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;

        this.cache.remove(currNode.key);
    }
}

class Node {
    Node next;
    Node prev;
    int key;
    int value;

    Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

/**
 * True blue design problems The RECENCY in this problem is based on the fact
 * that whenever an item is accessed, via GET or PUT, you would have to somehow
 * mark it as the MOST RECENT. Insted of FINDING the LEAST RECENTLY USED
 * element, you keep MARKING the most recently used element.
 * 
 * And if we continue the process, the element not accessed for the longes
 * period, would naturally shift to the LEFT boundary, which is where the LEAST
 * RECENTLY used element is
 * 
 * || HEAD -> ELEMENT -> ELEMENT -> ELEMENT -> TAIL ||
 * 
 * Node adjacent to the head is the LRU element and when the capacity is full,
 * we simply remove the right node of HEAD. For every other operation, we keep
 * adding the element to the left of the TAIL - That's the MRU
 */