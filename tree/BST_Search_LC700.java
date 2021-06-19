public class BST_Search_LC700 {
    // SDE problem
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        if (val < root.val)
            return searchBST(root.left, val);
        return searchBST(root.right, val);

    }

    public TreeNode searchBST_iterative(TreeNode root, int val) {
        while (root != null && root.val != val) {

            if (val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        if (root == null)
            return null;
        return root;
    }
}
/**
 * The recursion approach a TC of O(H) and worst case of O(N)
 * 
 */
