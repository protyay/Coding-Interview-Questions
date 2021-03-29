import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeRightSideView_LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return List.of();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        q.addLast(root);
        res.add(root.val);
        while (!q.isEmpty()) {
            Deque<TreeNode> nextLvl = new ArrayDeque<>();
            int size = q.size();
            while (size-- > 0) {
                TreeNode tail = q.removeFirst();
                if (tail.left != null)
                    nextLvl.addLast(tail.left);
                if (tail.right != null)
                    nextLvl.addLast(tail.right);
            }
            q = nextLvl;
            if (!nextLvl.isEmpty())
                res.add(nextLvl.getLast().val);
        }
        return res;
    }
}
