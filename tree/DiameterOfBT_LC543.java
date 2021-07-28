import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DiameterOfBT_LC543 {
    int diameter = 0;

    // SDE problem
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
    }

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

// Calc the max depth of for every subtree rooted at a particular node
class Iterative_DiameterOfBT {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return 0;

        int diameter = 0;
        Map<TreeNode, Integer> depthMap = new HashMap<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);

        // Post-order
        while (!stack.isEmpty()) {
            TreeNode currTop = stack.getFirst();

            if (currTop.left != null && !depthMap.containsKey(currTop.left))
                stack.addFirst(currTop.left);
            else if (currTop.right != null && !depthMap.containsKey(currTop.right))
                stack.addFirst(currTop.right);
            else {
                stack.removeFirst();
                int leftDepth = depthMap.getOrDefault(currTop.left, 0);
                int rightDepth = depthMap.getOrDefault(currTop.right, 0);

                diameter = Math.max(diameter, leftDepth + rightDepth);
                depthMap.put(currTop, 1 + Math.max(leftDepth, rightDepth));
            }
        }
        return diameter;
    }
}
/**
 * Very very similar to LC_687 Longest Univalue Length Where the ans is updated
 * in a global variable but the children info is passed to the parent pointer
 */
