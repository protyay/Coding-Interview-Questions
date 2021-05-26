import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeRightSideView_LC199 {
    // SDE // Repeat
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return List.of();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);

        while (!q.isEmpty()) {
            int size = q.size();
            int last = -101;

            while (size-- > 0) {
                TreeNode node = q.removeFirst();
                if (node.left != null) {
                    q.addLast(node.left);
                    last = node.left.val;
                }
                if (node.right != null) {
                    q.addLast(node.right);
                    last = node.right.val;
                }
            }
            // Pick the last element from R from all nodes at each level
            if (!q.isEmpty())
                ans.add(last);
        }
        return ans;
    }
}
