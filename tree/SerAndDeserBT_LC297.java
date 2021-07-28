import java.util.ArrayDeque;
import java.util.Deque;

public class SerAndDeserBT_LC297 {
    // SDE Problem
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        StringBuilder ans = new StringBuilder();
        ans.append(root.val).append(",");

        while (!q.isEmpty()) {
            TreeNode temp = q.removeFirst();
            String left = "null", right = "null";
            if (temp.left != null) {
                left = String.valueOf(temp.left.val);
                q.addLast(temp.left);
            }
            if (temp.right != null) {
                right = String.valueOf(temp.right.val);
                q.addLast(temp.right);
            }
            ans.append(left).append(",").append(right).append(",");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("null"))
            return null;
        String[] nodes = data.split(",");
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        q.addLast(root);
        int i = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.removeFirst();
            int left = 2 * i + 1, right = 2 * i + 2;
            if (left < nodes.length && !nodes[left].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[left]));
                temp.left = leftNode;
                q.addLast(temp.left);
            }
            if (right < nodes.length && !nodes[right].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[right]));
                temp.right = rightNode;
                q.addLast(temp.right);
            }
            ++i;
        }
        return root;
    }

    public static void main(String[] args) {
        String tree = "1,2,3,null,null,4,5";
        SerAndDeserBT_LC297 lc297 = new SerAndDeserBT_LC297();
        TreeNode root = lc297.deserialize(tree);
        String ans = lc297.serialize(root);
        System.out.println("Ans => " + ans);
        // System.out.println("root" + lc297.serialize(root));
    }
}

class ALternative_CodecBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder ans = new StringBuilder();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.removeFirst();
            ans.append(curr.val == -1001 ? "null" : curr.val);
            ans.append(",");
            TreeNode dummyNode = new TreeNode(-1001);
            // Add the dummyNode onnly if the currNode is NOT dummy
            if (curr.left == null && curr.val != -1001)
                q.addLast(dummyNode);
            else if (curr.left != null)
                q.addLast(curr.left);

            if (curr.right == null && curr.val != -1001)
                q.addLast(dummyNode);
            else if (curr.right != null)
                q.addLast(curr.right);
        }
        String treeStr = ans.deleteCharAt(ans.length() - 1).toString();
        return treeStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] nodes = data.split(",");
        Deque<TreeNode> q = new ArrayDeque<>();

        String root = nodes[0];
        if (root.equals("null") || root.isEmpty())
            return null;

        TreeNode rootNode = new TreeNode(Integer.parseInt(root));
        q.addLast(rootNode);
        int i = 0;
        while (!q.isEmpty()) {
            TreeNode curr = q.removeFirst();
            if (i * 2 + 1 < nodes.length && !nodes[i * 2 + 1].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[i * 2 + 1]));
                curr.left = leftNode;
                q.addLast(leftNode);
            }
            if (i * 2 + 2 < nodes.length && !nodes[i * 2 + 2].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[i * 2 + 2]));
                curr.right = rightNode;
                q.addLast(rightNode);
            }
            ++i;
        }
        return rootNode;
    }

    public static void main(String[] args) {
        String tree = "1,2,3,null,null,4,5";
        ALternative_CodecBT codecBT = new ALternative_CodecBT();
        TreeNode root = codecBT.deserialize(tree);
        String ans = codecBT.serialize(root);
        System.out.println("Ans => " + ans);
        // System.out.println("root" + lc297.serialize(root));
    }
}