import java.util.ArrayDeque;
import java.util.Deque;

public class NextRightNode_BS917 {
    public Tree solve(Tree tree, int target) {
        // If root is the target
        if (tree == null || target == tree.val)
            return null;
        Deque<Tree> nodes = new ArrayDeque<>();

        nodes.addLast(tree);
        while (!nodes.isEmpty()) {
            Deque<Tree> nextLevel = new ArrayDeque<>();
            int size = nodes.size();
            while (size-- > 0) {
                Tree currNode = nodes.removeFirst();
                if (currNode.val == target)
                    return nodes.isEmpty() ? null : nodes.getFirst();
                if (currNode.left != null)
                    nextLevel.addLast(currNode.left);
                if (currNode.right != null)
                    nextLevel.addLast(currNode.right);
            }
            nodes = nextLevel;
        }
        return null;
    }
}
