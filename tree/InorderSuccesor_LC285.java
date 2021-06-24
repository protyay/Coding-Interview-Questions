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

    public TreeNode inorderSuccessor_recursive(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val)
            return inorderSuccessor(root.right, p);
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }
    /**
     * If cur.val > p.val, then
     * it can be two cases: a) cur is an ancestor of p with value > p --> Record the value, go left to
     * find smaller values > p b) cur is in right subtree of p (actually must be a
     * right child of p) --> go left to find smaller values > p If cur.val <= p.val,
     * it can be: a) cur == p --> go right to find values > p b) cur is an ancestor
     * of p with value < p --> go right to find values > p
     **/

}

class InorderSuccessorOfBT {
    class Solution {

        private TreeNode previous;
        private TreeNode inorderSuccessorNode;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            // Case 1: We simply need to find the leftmost node in the subtree rooted at
            // p.right.
            if (p.right != null) {

                TreeNode leftmost = p.right;

                while (leftmost.left != null) {
                    leftmost = leftmost.left;
                }

                this.inorderSuccessorNode = leftmost;
            } else {

                // Case 2: We need to perform the standard inorder traversal and keep track of
                // the previous node.
                this.inorderCase2(root, p);
            }

            return this.inorderSuccessorNode;
        }

        private void inorderCase2(TreeNode node, TreeNode p) {

            if (node == null) {
                return;
            }

            // Recurse on the left side
            this.inorderCase2(node.left, p);

            // Check if previous is the inorder predecessor of node
            if (this.previous == p && this.inorderSuccessorNode == null) {
                this.inorderSuccessorNode = node;
                return;
            }

            // Keeping previous up-to-date for further recursions
            this.previous = node;

            // Recurse on the right side
            this.inorderCase2(node.right, p);
        }
    }
}
