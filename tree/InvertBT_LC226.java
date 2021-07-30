import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * This is also a typical pointer manipulation, @link{RemoveHalfNodes_IB.java}
 * SDE problem
 */
public class InvertBT_LC226 {
    public TreeNode invertTree(TreeNode A) {
        if (A == null)
            return null;
        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);
        TreeNode tmp = left;
        A.left = right;
        A.right = tmp;
        return A;
    }

    public TreeNode iterative_invertTree(TreeNode A) {
        if (A == null)
            return null;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.addFirst(A);
        Set<TreeNode> seen = new HashSet<>();
        while (!st.isEmpty()) {
            TreeNode curr = st.getFirst();
            if (curr.left != null && !seen.contains(curr.left))
                st.addFirst(curr.left);
            else if (curr.right != null && !seen.contains(curr.right))
                st.addFirst(curr.right);
            else {
                st.removeFirst();
                seen.add(curr);
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        SerAndDeserBT_LC297 lc297 = new SerAndDeserBT_LC297();
        TreeNode root = lc297.deserialize("4,2,7,1,3,6,9");
        InvertBT_LC226 lc226 = new InvertBT_LC226();
        System.out.println(lc297.serialize(lc226.iterative_invertTree(root)));
    }
}
/**
 * If tree is typically a pointer manipulation program, then reach the left-most
 * leaf node
 * 
 * Start manipulating tree from the leaf. Build upwards to the root
 */
