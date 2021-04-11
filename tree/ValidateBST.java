public class ValidateBST {
    public boolean solve(Tree root) {

        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(Tree root, int min, int max) {
        if (root == null)
            return true;
        if (root.val < min || root.val > max)
            return false;
        boolean l = false, r = false;
        l = validate(root.left, min, root.val);
        if(l)
          r = validate(root.right, root.val, max);
        return l && r;
    }
}
