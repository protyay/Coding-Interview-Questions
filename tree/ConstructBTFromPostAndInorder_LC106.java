import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPostAndInorder_LC106 {
    int postPointer = -1;
    // SDE 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Maintain a pointer for postorder.
        // Start iterating from the reverse of the array
        // Build Map from the inorder and use it to fetch the current root element's
        // inorder index
        Map<Integer, Integer> inorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }
        int N = postorder.length;
        postPointer = N - 1;
        return buildTree(postorder, 0, N - 1, inorderIdx);
    }

    private TreeNode buildTree(int[] postorder, int inF, int inE, Map<Integer, Integer> inorderIdx) {
        if (inF > inE)
            return null;
        int rootVal = postorder[postPointer--];
        TreeNode currRoot = new TreeNode(rootVal);
        if (inF == inE)
            return currRoot;

        int inIndex = inorderIdx.get(rootVal);
        // Build the right subtree first in case of postorder
        currRoot.right = buildTree(postorder, inIndex + 1, inE, inorderIdx);
        currRoot.left = buildTree(postorder, inF, inIndex - 1, inorderIdx);

        return currRoot;
    }
}
/**
 * Because your post pointer decreases in a way that traverse all the right subtree nodes, first, 
 * we'll have to accomodate that and build the R-subtree first and then the L-subtree
 */
