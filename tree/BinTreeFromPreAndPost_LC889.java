public class BinTreeFromPreAndPost_LC889 {
    private int preIndex = 0, postIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[postIndex])
            root.left = constructFromPrePost(pre, post);

        if (root.val != post[postIndex])
            root.right = constructFromPrePost(pre, post);

        ++postIndex;
        return root;
    }

    public static void main(String[] args) {
        int[] pre = { 3, 9, 20, 15, 7 };
        int[] post = { 9, 15, 7, 20, 3 };

        TreeNode ans = new BinTreeFromPreAndPost_LC889().constructFromPrePost(pre, post);
        System.out.println(ans);
    }

}
/**
 * It's very important to try to draw the diagram Once we fix a value we keep
 * building the left subtree from the pre order array until we hit that element
 * The logic behind this is in post order traversal LEFT is the first node
 * visited in a subtree. So, we won't have any more left nodes
 */
