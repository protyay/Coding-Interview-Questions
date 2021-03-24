public class IsomorphicTrees_LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String encodeP = encode(p);
        String encodeQ = encode(q);
        System.out.println(encodeP);
        System.out.println(encodeQ);
        return encodeP.equals(encodeQ);
    }
    private String encode(TreeNode node){
      if(node == null) return "#";
      String left = encode(node.left);
      left = left +"("+ String.valueOf(node.val);
      String right = encode(node.right);
      right = right + ")" +String.valueOf(node.val);
      return left + right;
    }
}
