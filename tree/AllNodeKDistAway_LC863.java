import java.util.*;

public class AllNodeKDistAway_LC863 {
    // SDE V.VImportant
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, root);
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(target);
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode temp = q.removeFirst();
                if (k == 0) {
                    res.add(temp.val);
                }
                visited.add(temp);
                TreeNode parent = this.parentMap.getOrDefault(temp, null);
                if (parent != null && !visited.contains(parent))
                    q.addLast(parent);
                if (temp.left != null && !visited.contains(temp.left))
                    q.addLast(temp.left);
                if (temp.right != null && !visited.contains(temp.right))
                    q.addLast(temp.right);
            }
            if (k == 0)
                break;
            --k;
        }
        return res;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null)
            return;

        this.parentMap.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
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
