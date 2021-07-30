import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestor_LC236 {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        lca(root, p, q);

        return ans;
    }

    // It is always important to complete the full traversal of the tree
    // Build from the bottom up
    private int lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;
        int l = lca(root.left, p, q);

        int r = lca(root.right, p, q);

        int curr = root.val == p.val || root.val == q.val ? 1 : 0;

        if ((l + r >= 2) && ans == null) {
            ans = root;
        }
        return l + r + curr;
    }

    public TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        Map<TreeNode, Integer> lca = new HashMap<>();
        int k = 2;
        while (!stack.isEmpty()) {
            TreeNode top = stack.getFirst();
            if (top.left != null && !lca.containsKey(top.left))
                stack.addFirst(top.left);
            else if (top.right != null && !lca.containsKey(top.right))
                stack.addFirst(top.right);
            else {
                stack.removeFirst();
                int leftCount = lca.getOrDefault(top.left, 0);
                int rightCount = lca.getOrDefault(top.right, 0);
                int self = p.val == top.val || q.val == top.val ? 1 : 0;

                if (leftCount + rightCount + self == k)
                    return top;

                lca.put(top, self + rightCount + leftCount);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String data = "3,5,1,6,2,0,8,null,null,7,4";
        SerAndDeserBT_LC297 lc297 = new SerAndDeserBT_LC297();
        TreeNode root = lc297.deserialize(data);
        LowestCommonAncestor_LC236 lc236 = new LowestCommonAncestor_LC236();
        TreeNode lca = lc236.lowestCommonAncestor_iterative(root, root.left, root.right);
        System.out.println("LCA NODE =" + lca.val);
    }
}
/**
 * This is one of the most important question.
 * 
 * This algorithm would traverse the whole tree even if the given nodes are
 * found at the top. That's okay.
 * 
 * The clean template is that standing at a current node, we give back the total
 * of left + total of right + current. Assumably it is less than 2.
 * 
 * We can reuse this method in many other problems where the parent node gathers
 * information from it's left and right children, add it's own information and
 * pass it on to it's parent.
 * 
 * TC - O(N) SC - O(N)
 */
