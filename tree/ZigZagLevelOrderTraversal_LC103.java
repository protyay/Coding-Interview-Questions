import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagLevelOrderTraversal_LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return List.of();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        boolean reverse = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelNodes = new ArrayList<>();
            while (size-- > 0) {
                TreeNode top = q.removeFirst();
                if (top.left != null)
                    q.addLast(top.left);
                if (top.right != null)
                    q.addLast(top.right);

                if (reverse)
                    levelNodes.add(0, top.val);
                else
                    levelNodes.add(top.val);
            }
            reverse = !reverse;
            result.add(levelNodes);
        }
        return result;
    }
}
