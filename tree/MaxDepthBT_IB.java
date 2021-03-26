public class MaxDepthBT_IB {
    public int maxDepth(TreeNode A) {
        if (A == null)
            return 0;
        int left = maxDepth(A.left);
        int right = maxDepth(A.right);

        return 1 + Math.max(left, right);
    }
}
