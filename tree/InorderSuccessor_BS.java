import java.util.ArrayDeque;
import java.util.Deque;

/**
 * One of the most important question, we can implement ceil in a BST Try to
 * implement predecessor , we can answer floor with this
 */
public class InorderSuccessor_BS {
    public int solve(Tree root, int t) {
        Deque<Tree> stack = new ArrayDeque<>();
        dfs(root, stack);
        while (!stack.isEmpty()) {
            Tree currNode = stack.removeFirst();
            if (currNode.val > t)
                return currNode.val;
            dfs(currNode.right, stack);
        }
        return -1;
    }

    // Fill nodes till the Height of the tree
    private void dfs(Tree root, Deque<Tree> stack) {
        if (root == null)
            return;
        stack.addFirst(root);
        dfs(root.left, stack);

    }
}
