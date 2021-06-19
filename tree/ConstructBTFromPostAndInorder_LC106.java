import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPostAndInorder_LC106 {
    // SDE problem
    int post = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int l, int r) {
        if (l > r)
            return null;

        int currValue = postorder[post--];
        TreeNode rootNode = new TreeNode(currValue);

        if (l == r)
            return rootNode;

        int inIndex = inorderMap.get(currValue);

        rootNode.right = buildTree(postorder, inIndex + 1, r);
        rootNode.left = buildTree(postorder, l, inIndex - 1);

        return rootNode;

    }
}
/**
 * Because your post pointer decreases in a way that traverse all the right
 * subtree nodes, first, we'll have to accomodate that and build the R-subtree
 * first and then the L-subtree
 */
