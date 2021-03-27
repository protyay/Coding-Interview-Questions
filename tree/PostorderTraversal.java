import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class PostorderTraversal {
    // Root, right, left -> Reverse of Preorder
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.removeFirst();

            nodes.add(top.val);
            if (top.left != null)
                stack.addFirst(top.left);
            if (top.right != null)
                stack.addFirst(top.right);
        }
        Collections.reverse(nodes);
        return nodes;
    }

}
