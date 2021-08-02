import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VerticalOrderTraversal_LC987 {

    public List<List<Integer>> verticalTraversal(TreeNode node) {
        int min = 0, max = 0;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<NodeInfo> stack = new ArrayDeque<>();
        if (node == null)
            return List.of();
        if (node.left == null && node.right == null)
            return List.of(List.of(node.val));

        // [-2, [5]], [-1,[2]], [0, [1,6]], [1,[3]]
        Map<Integer, List<ValueInfo>> indexNodes = new HashMap<>();
        stack.addFirst(new NodeInfo(node, 0, 0));
        Set<TreeNode> seen = new HashSet<>();

        while (!stack.isEmpty()) {
            NodeInfo top = stack.getFirst();

            if (top.node.left != null && !seen.contains(top.node.left)) {
                int verticalIndex = top.verticalIndex - 1;
                int row = top.rowIndex + 1;
                min = Math.min(min, verticalIndex);
                stack.addFirst(new NodeInfo(top.node.left, verticalIndex, row));
            } else if (top.node.right != null && !seen.contains(top.node.right)) {
                int verticalIndex = top.verticalIndex + 1;
                int row = top.rowIndex + 1;
                max = Math.max(max, verticalIndex);
                stack.addFirst(new NodeInfo(top.node.right, verticalIndex, row));
            } else {
                top = stack.removeFirst();
                seen.add(top.node);
                indexNodes.computeIfAbsent(top.verticalIndex, r -> new ArrayList<ValueInfo>());
                indexNodes.get(top.verticalIndex).add(new ValueInfo(top.rowIndex, top.node.val));
            }
        }

        for (int start = min; start <= max; start++) {
            if (!indexNodes.containsKey(start))
                continue;
            List<ValueInfo> vertical = indexNodes.get(start);
            Comparator<ValueInfo> rowInfo = Comparator.comparingInt(a -> a.rowIndex);
            Comparator<ValueInfo> valKey = rowInfo.thenComparing(Comparator.comparingInt(a -> a.value));

            Collections.sort(vertical, valKey);
            ans.add(vertical.stream().map(i -> i.value).collect(Collectors.toList()));
        }
        return ans;
    }

    class NodeInfo {
        TreeNode node;
        int verticalIndex;
        int rowIndex;

        NodeInfo(TreeNode node, int vertIdx, int rowIndex) {
            this.node = node;
            this.verticalIndex = vertIdx;
            this.rowIndex = rowIndex;
        }
    }

    class ValueInfo {
        int rowIndex;
        int value;

        ValueInfo(int rowIndex, int value) {
            this.rowIndex = rowIndex;
            this.value = value;
        }
    }
}
