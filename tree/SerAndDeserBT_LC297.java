import java.util.ArrayDeque;
import java.util.Deque;

public class SerAndDeserBT_LC297 {
    // SDE Problem
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.addLast(root);
        StringBuffer ans = new StringBuffer();
        ans.append(root.val);
        ans.append(",");
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- > 0) {
                TreeNode node = nodes.removeFirst();
                String leftNodeVal = "null";
                if (node.left != null) {
                    leftNodeVal = String.valueOf(node.left.val);
                    nodes.addLast(node.left);
                }
                ans.append(leftNodeVal);
                ans.append(",");

                String rightNodeVal = "null";
                if (node.right != null) {
                    rightNodeVal = String.valueOf(node.right.val);
                    nodes.addLast(node.right);
                }
                ans.append(rightNodeVal);
                ans.append(",");
            }
        }
        ans.deleteCharAt(ans.length() - 1);// Delete the xtra comma char
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // We validate that the tree has atleast one node
        if (data == null || data.length() < 3)
            return null;

        String[] nodeData = data.split(",");
        Deque<TreeNode> nodes = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeData[0]));

        nodes.addLast(root);
        int index = 0;
        while (!nodes.isEmpty()) {
            TreeNode temp = nodes.removeFirst();
            int lIdx = 2 * index + 1, rIdx = 2 * index + 2;
            if (lIdx < nodeData.length && !nodeData[lIdx].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodeData[lIdx]));
                temp.left = left;
                nodes.addLast(left);
            }
            if (rIdx < nodeData.length && !nodeData[rIdx].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodeData[rIdx]));
                temp.right = right;
                nodes.addLast(right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        String tree = "[1,2,3,null,null,4,5]";
        SerAndDeserBT_LC297 lc297 = new SerAndDeserBT_LC297();
        TreeNode root = lc297.deserialize(tree);
        System.out.println("root" + lc297.serialize(root));
    }
}
