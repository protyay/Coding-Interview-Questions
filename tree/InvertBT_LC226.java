/**
 * This is also a typical pointer manipulation, @link{RemoveHalfNodes_IB.java}
 */
public class InvertBT_LC226 {
    public TreeNode invertTree(TreeNode A) {
        if (A == null)
            return null;
        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);
        TreeNode tmp = left;
        A.left = right;
        A.right = tmp;
        return A;
    }
}
