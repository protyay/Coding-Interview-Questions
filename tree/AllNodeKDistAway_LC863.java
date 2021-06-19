import java.util.*;

public class AllNodeKDistAway_LC863 {
    // SDE V.VImportant
    public int[] solve(Tree root, int target, int radius) {
        if (root == null)
            return new int[] {};
        Map<Tree, Tree> parentMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Set<Tree> visited = new HashSet<>();
        populateMap(parentMap, root, null);

        Tree targetNode = null;
        for (Tree node : parentMap.keySet()) {
            if (node.val == target) {
                targetNode = node;
                break;
            }
        }
        // BFS from the targetNode
        Deque<Tree> q = new ArrayDeque<>();
        q.addLast(targetNode);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Tree currNode = q.removeFirst();
                visited.add(currNode);

                if (radius == 0)
                    res.add(currNode.val);

                Tree parent = parentMap.get(targetNode);
                // Add left , right child as well as parent. Nodes we can visit in one UNIT of
                // time
                if (currNode.left != null && !visited.contains(currNode.left))
                    q.addLast(currNode.left);
                if (currNode.right != null && !visited.contains(currNode.right))
                    q.addLast(currNode.right);
                if (parent != null && !visited.contains(parent))
                    q.addLast(parent);
            }
            if (radius == 0)
                break;
            --radius;
        }
        Collections.sort(res);
        int[] ans = res.stream().mapToInt(i -> i).toArray();

        return ans;
    }

    private void populateMap(Map<Tree, Tree> parentMap, Tree root, Tree parent) {
        if (root == null)
            return;
        parentMap.put(root, parent);

        populateMap(parentMap, root.left, root);
        populateMap(parentMap, root.right, root);
    }
}
/**
 * We can achieve so much if we traverse the whole tree and build parent
 * pointers. Let's say , we want to find redundant edge in a tree. If we
 * encounter a node with two different parents, it simply means there's a
 * redundant edge
 * 
 * Also, parent pointer is a great link to traverse the whole tree from a
 * certain point.
 * 
 */
