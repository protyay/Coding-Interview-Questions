import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinTreeFromPreAndIn_LC105 {
    int prePointer = 0;

    // SDE // Repeat
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

/**
 * Maintain a preorder index pointer Propertly maintain off-by-one error for
 * inorder index Maintain a map of inorder index
 */
class IterativeTreeBuilding {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode rootNode = new TreeNode(preorder[0]);  
        stack.addFirst(rootNode);
        int N = preorder.length;

        for (int i = 1, j = 0; i < N; i++) {
            TreeNode ancestor = null;
            while (j < N && !stack.isEmpty() && stack.getFirst().val == inorder[j]) {
                ancestor = stack.removeFirst();
                j++;
            }
            TreeNode currNode = new TreeNode(preorder[i]);
            if (ancestor == null)
                stack.getFirst().left = currNode;
            else
                ancestor.right = currNode;
            stack.addFirst(currNode);
        }
        return rootNode;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 };
        IterativeTreeBuilding treeBuilding = new IterativeTreeBuilding();
        TreeNode root = treeBuilding.buildTree(preorder, inorder);
        SerAndDeserBT_LC297 lc297 = new SerAndDeserBT_LC297();
        System.out.println(lc297.serialize(root));
    }
}