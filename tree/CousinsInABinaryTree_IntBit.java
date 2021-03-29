import java.util.*;

public class CousinsInABinaryTree_IntBit {
    public int[] solve(TreeNode A, int B) {
        if (A == null || A.val == B)
            return new int[] {};
        List<Integer> siblings = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(A);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode currNode = q.removeFirst();
                if (currNode.left != null && currNode.left.val == B
                        || currNode.right != null && currNode.right.val == B) {
                    addCousins(q, siblings);
                    break;
                } else {
                    if (currNode.left != null)
                        q.addLast(currNode.left);
                    if (currNode.right != null)
                        q.addLast(currNode.right);
                }
            }
        }
        int[] ans = siblings.stream().mapToInt(i -> i).toArray();
        return ans;
    }

    private void addCousins(Deque<TreeNode> q, List<Integer> siblings) {
        while (!q.isEmpty()) {
            TreeNode node = q.removeFirst();
            if (node.left != null)
                siblings.add(node.left.val);
            if (node.right != null)
                siblings.add(node.right.val);
        }
    }

    public static void main(String[] args) {
        CousinsInABinaryTree_IntBit binaryTree = new CousinsInABinaryTree_IntBit();
        String input = "[1,2,3,4,5,6,7]";
        TreeNode rootNode = TreeNodeBuilder.stringToTreeNode(input);
        int[] ans = binaryTree.solve(rootNode, 2);
        System.out.println(Arrays.toString(ans));

    }
}

class TreeNodeBuilder {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
