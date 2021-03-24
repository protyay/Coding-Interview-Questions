import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTrav_BS70 {
    public int[] solve(Tree root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return new int[] {};
        Deque<Tree> nodes = new ArrayDeque<>();
        nodes.addLast(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- > 0) {
                Tree currNode = nodes.removeFirst();
                res.add(currNode.val);
                if (currNode.left != null)
                    nodes.add(currNode.left);
                if (currNode.right != null)
                    nodes.add(currNode.right);
            }
        }
        int[] ans = res.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}
