import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Wonderful problem. The idea is to choose the BFS traversal which takes O(N) time
 */
public class MinDepth_IB {
    public int minDepth(TreeNode A) {
        if (A == null)
            return 0;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        int depth = 1;
        nodes.addLast(A);

        while (!nodes.isEmpty()) {
            int l = nodes.size();
            while (l-- > 0) {
                TreeNode currNode = nodes.removeFirst();
                if (currNode.left == null && currNode.right == null)
                    return depth;
                if (currNode.left != null)
                    nodes.addLast(currNode.left);
                if (currNode.right != null)
                    nodes.addLast(currNode.right);
            }
            ++depth;
        }
        return depth;
    }
}
