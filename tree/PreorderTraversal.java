import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal_itertative(TreeNode root) {
        if (root == null)
            return List.of();

        List<Integer> traversal = new ArrayList<>();
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        fillNodes(root, treeNodes, traversal);

        while (!treeNodes.isEmpty()) {
            TreeNode currNode = treeNodes.removeFirst();
            fillNodes(currNode.right, treeNodes, traversal);
        }
        return traversal;
    }

    private void fillNodes(TreeNode root, Deque<TreeNode> treeNodes, List<Integer> vals) {
        while (root != null) {
            vals.add(root.val);
            treeNodes.addFirst(root);
            root = root.left;
        }
    }
    /**
     * Recursive Implementation for Preorder traversal
     * @param root
     * @param nodes
     */
    private void walkPreOrder(TreeNode root,List<Integer> nodes){
        if(root == null) return;
        
        nodes.add(root.val);
        walkPreOrder(root.left, nodes);
        walkPreOrder(root.right, nodes);
  }
}
