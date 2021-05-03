import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph_LC133 {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        Map<Node, Node> clonedMap = new HashMap<>();

        clonedMap.put(node, new Node(node.val, new ArrayList<>()));

        Deque<Node> nodes = new ArrayDeque<>();
        nodes.addLast(node);

        while (!nodes.isEmpty()) {
            // Fetch the old Node
            Node oldNode = nodes.removeFirst();
            for (Node n : oldNode.neighbors) {
                // If this neighbor is NOT visited
                if (!clonedMap.containsKey(n)) {
                    clonedMap.put(n, new Node(n.val, new ArrayList<>()));
                    nodes.addLast(n);
                }
                // Update the cloned node's neighbour with the neighbors
                clonedMap.get(oldNode).neighbors.add(clonedMap.get(n));
            }
        }
        return clonedMap.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
/**
 * Cloning a graph involved three steps - 
 * 
 * One clone the node itself. 
 * Second, clone all the neighbours.
 * At each point, add the oldNodes to the q.
 * Third, add the cloned neighbours to the adjacency list of the cloned node
 * 
 * 
 */