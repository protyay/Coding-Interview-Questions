/**
 * The typical idea is to store the values returned at each level of three
 * and perform pointer manipulation
 */
public class RemoveHalfNodes_IB {
    public TreeNode solve(TreeNode A) {
        if (A == null)
            return null;

        TreeNode left = solve(A.left);
        A.left = left;
        TreeNode right = solve(A.right);
        A.right = right;

        if (A.left == null && A.right == null)
            return A;
        if (A.left == null || A.right == null)
            return A.left == null ? A.right : A.left;

        return A;
    }
}
