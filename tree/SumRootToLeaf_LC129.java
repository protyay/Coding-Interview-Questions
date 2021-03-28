public class SumRootToLeaf_LC129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        sum(root, 0);
        return sum;
    }

    private void sum(TreeNode root, int partialSum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += (partialSum * 10) + root.val;
            return;
        }
        sum(root.left, (partialSum * 10) + root.val);
        sum(root.right, (partialSum * 10) + root.val);
    }
}
