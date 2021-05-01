public class IsomorphicTrees_LC100 {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    String encodeP = encode(p);
    String encodeQ = encode(q);
    System.out.println(encodeP);
    System.out.println(encodeQ);
    return encodeP.equals(encodeQ);
  }

  private String encode(TreeNode node) {
    if (node == null)
      return "#";
    String left = encode(node.left);
    left = left + "(" + String.valueOf(node.val);
    String right = encode(node.right);
    right = right + ")" + String.valueOf(node.val);
    return left + right;
  }
}
/**
 * String concatenation is painfully slow . This is the fastest DFS approach.
 * Very similar to LC101 solution
 */
class TwinTrees_BS66 {
  public boolean solve(Tree root0, Tree root1) {
    if (root0 == null && root1 == null)
      return true;
    if (root0 == null || root1 == null)
      return false;
    if (root0.val != root1.val)
      return false;
    return solve(root0.left, root1.left) && solve(root0.right, root1.right);
  }
}
