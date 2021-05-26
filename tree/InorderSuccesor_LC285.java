public class InorderSuccesor_LC285 {
    // SDE problem
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // Inorder successor is the left most node in the right subtree.
        // If the right subtree is empty, then we simply say the parent is
        // the inorder successor
        TreeNode ans = null;
        while (root != null) {
            if (p.val < root.val) {
                ans = root;
                root = root.left;
            } else if (p.val >= root.val) {
                root = root.right;
            }
        }
        return ans;
    }
}
