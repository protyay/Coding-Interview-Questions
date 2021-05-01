public class IsSymmetric_LC101 {
    // SDE problem 
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return checkSym(root.left, root.right);
    }

    private boolean checkSym(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        return a.val == b.val && checkSym(a.left, b.right) && checkSym(a.right, b.left);
    }
}
/**
 * Very important problem where we need to compare two trees 
 */
