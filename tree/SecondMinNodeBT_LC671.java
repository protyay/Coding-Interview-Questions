import java.util.PriorityQueue;
import java.util.Queue;

public class SecondMinNodeBT_LC671 {
    public int findSecondMinimumValue(TreeNode root) {

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        dfs(root, maxHeap);

        if (maxHeap.size() < 2)
            return -1;
        else
            return maxHeap.remove();
    }

    private void dfs(TreeNode root, Queue<Integer> maxHeap) {
        if (root == null)
            return;
        if (maxHeap.size() < 2 && !maxHeap.contains(root.val))
            maxHeap.add(root.val);
        else {
            if (maxHeap.peek() > root.val && !maxHeap.contains(root.val)) {
                maxHeap.poll();
                maxHeap.add(root.val);
            }
        }
        dfs(root.left, maxHeap);
        dfs(root.right, maxHeap);
    }
}
/**
 * This would have been a cool problem, if let's say, we do not had to use the contains check
 * 
 */
