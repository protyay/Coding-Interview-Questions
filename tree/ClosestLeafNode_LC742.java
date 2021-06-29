import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClosestLeafNode_LC742 {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    TreeNode targetNode = null;
    int K = 0;

    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null)
            return 0;
        this.K = k;
        Set<TreeNode> visited = new HashSet<>();
        TreeNode rootParent = root.right == null ? root : root.right;

        dfs(root, rootParent);// Slight modification from the k distance
        if (targetNode == null)
            throw new IllegalArgumentException("Invalid value of K");

        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(targetNode);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode temp = q.removeFirst();

                // If temp is the leaf node, then we return the value
                if (temp.left == null && temp.right == null)
                    return temp.val;
                visited.add(temp);

                if (parentMap.getOrDefault(temp, null) != null && !visited.contains(parentMap.get(temp)))
                    q.addLast(parentMap.get(temp));
                if (temp.left != null && !visited.contains(temp.left))
                    q.addLast(temp.left);
                if (temp.right != null && !visited.contains(temp.right))
                    q.addLast(temp.right);
            }
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null)
            return;
        if (root.val == this.K)
            targetNode = root;

        this.parentMap.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public static void main(String[] args) {
        String tree = "1,2,3,4,null,null,null,5,null,6";
        SerAndDeserBT_LC297 lc297 = new SerAndDeserBT_LC297();
        TreeNode rootNode = lc297.deserialize(tree);

        ClosestLeafNode_LC742 lc742 = new ClosestLeafNode_LC742();
        int findClosestLeaf = lc742.findClosestLeaf(rootNode, 2);
        System.out.println("Closest leaf =" + findClosestLeaf);
    }

}
