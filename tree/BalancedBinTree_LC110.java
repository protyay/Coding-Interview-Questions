public class BalancedBinTree_LC110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return calcHeight(root) != -1;
    }

    private int calcHeight(TreeNode root) {
        if (root == null)
            return 0;

        int l = calcHeight(root.left);
        int r = calcHeight(root.right);

        if (l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;

        return 1 + Math.max(l, r);
    }
}
