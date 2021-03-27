import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        if (root == null)
            return List.of();

        List<Integer> traversal = new ArrayList<>();
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        fillNodes(root, treeNodes);

        while (!treeNodes.isEmpty()) {
            // Pop the topNode and add to result
            TreeNode currNode = treeNodes.removeFirst();
            traversal.add(currNode.val);
            fillNodes(currNode.right, treeNodes);
        }
        return traversal;
    }

    private void fillNodes(TreeNode root, Deque<TreeNode> treeNodes) {
        while (root != null) {
            treeNodes.addFirst(root);
            root = root.left;
        }
    }

    public List<Integer> inorderTraversal_Recursive(TreeNode root) {
        List<Integer> nodeVals = new ArrayList<>();
        walkInOrder(root, nodeVals);
        return nodeVals;
    }

    private void walkInOrder(TreeNode root, List<Integer> nodeVals) {
        if (root == null)
            return;
        walkInOrder(root.left, nodeVals);
        nodeVals.add(root.val);
        walkInOrder(root.right, nodeVals);
    }
}
