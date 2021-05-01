import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    private int count = 0;
    // SDE problem
    public int pathSum(TreeNode root, int sum) {
        // write your code here
        Map<Integer, Integer> nodeSum = new HashMap<>();
        nodeSum.put(0, 1);
        recurse(root, sum, 0, nodeSum);
        return count;
    }

    private void recurse(TreeNode root, int sum, int partialSum, Map<Integer, Integer> nodeSum) {
        if (root == null)
            return;
        if (nodeSum.containsKey((partialSum + root.val) - sum)) {
            count += nodeSum.get((partialSum + root.val) - sum);
        }
        nodeSum.put(partialSum + root.val, nodeSum.getOrDefault((partialSum + root.val), 0) + 1);

        recurse(root.left, sum, partialSum + root.val, nodeSum);
        recurse(root.right, sum, partialSum + root.val, nodeSum);
        int currentNodeSum = partialSum + root.val;

        if (nodeSum.containsKey(currentNodeSum)) {
            int freq = nodeSum.get(currentNodeSum);
            if (freq - 1 == 0)
                nodeSum.remove(currentNodeSum);
            else
                nodeSum.put(currentNodeSum, freq - 1);
        }
    }

    public static void main(String[] args) {
        PathSum3 ps = new PathSum3();
        // {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeNodeBuilder.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        int ans = ps.pathSum(root, 8);
        System.out.println("Total ways = " + ans);
    }
}
/**
 * One of the most favourite backtracking question implementation
 */