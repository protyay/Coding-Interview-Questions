public class DiameterOfBT_LC543 {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
    }

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
/**
 * Very very similar to LC_687 Longest Univalue Length Where the ans is updated
 * in a global variable but the children info is passed to the parent pointer
 */
