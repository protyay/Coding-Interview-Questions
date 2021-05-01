import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDepthOfBT_LC104 {
    // SDE problem
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> q = new ArrayDeque<>();

        q.addLast(root);

        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode currNode = q.removeFirst();
                if (currNode.left != null)
                    q.addLast(currNode.left);
                if (currNode.right != null)
                    q.addLast(currNode.right);
            }
            if (!q.isEmpty())
                ++depth;
        }
        return depth;
    }
    //DFS approach
    public int maxDepth_DFS(TreeNode root) {
        if(root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        
        return 1 + Math.max(l, r);
    }
}
