import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallest_IB {
    public class Solution {
        public int kthsmallest(TreeNode A, int B) {
            Deque<TreeNode> nodes = new ArrayDeque<>();
            dfs(A, nodes);
            while (!nodes.isEmpty()) {
                TreeNode top = nodes.removeFirst();
                B--;
                if (B == 0)
                    return top.val;
                dfs(top.right, nodes);// Fill the stack with right subtree
            }
            return -1;
        }

        private void dfs(TreeNode root, Deque<TreeNode> nodes) {
            if (root == null)
                return;
            nodes.addFirst(root);
            dfs(root.left, nodes);
        }
    }
}
