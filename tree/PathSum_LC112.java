public class PathSum_LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && targetSum - root.val == 0)
            return true;

        if (root.left != null && hasPathSum(root.left, targetSum - root.val)
                || (root.right != null && hasPathSum(root.right, targetSum - root.val)))
            return true;
        return false;
    }
}
