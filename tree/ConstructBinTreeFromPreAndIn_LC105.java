import java.util.HashMap;
import java.util.Map;

public class ConstructBinTreeFromPreAndIn_LC105 {
    int prePointer = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int N = inorder.length;
        Map<Integer, Integer> inorderIdx = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inorderIdx.put(inorder[i], i);
        }
        return buildTree(preorder, 0, N - 1, inorderIdx);
    }

    private TreeNode buildTree(int[] pre, int inF, int inE, Map<Integer, Integer> inNodeIdx) {
        if (inF > inE)
            return null;
        int currRoot = pre[prePointer++];
        TreeNode root = new TreeNode(currRoot);

        if (inF == inE)
            return root; // Leaf node scenario. Inorder range has ONLY one element
        int inIndex = inNodeIdx.get(currRoot);

        // Split the in-order based on the root value's index
        root.left = buildTree(pre, inF, inIndex - 1, inNodeIdx);
        root.right = buildTree(pre, inIndex + 1, inE, inNodeIdx);

        return root;
    }
}
