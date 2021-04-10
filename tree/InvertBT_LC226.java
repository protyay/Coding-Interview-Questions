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
/**
 * If tree is typically a pointer manipulation program, then
 * reach the left-most leaf node 
 * 
 * Start manipulating tree from the leaf. Build upwards to the root
 */
