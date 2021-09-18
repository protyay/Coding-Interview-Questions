public class IsSymmetric_LC101 {
    // SDE problem
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return checkSym(root.left, root.right);
    }

    private boolean checkSym(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        return a.val == b.val && checkSym(a.left, b.right) && checkSym(a.right, b.left);
    }
}

class SymmetricTree_Iterative {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        Deque<Children> q = new ArrayDeque<>();

        q.addLast(new Children(root.left, root.right));

        while (!q.isEmpty()) {
            Children pair = q.removeFirst();

            TreeNode l = pair.left, r = pair.right;
            if (l == null && r == null)
                continue;
            if (l == null || r == null)
                return false;

            if (l.val != r.val)
                return false;

            // The magic starts here
            Children symA = new Children(l.left, r.right);
            Children symB = new Children(l.right, r.left);

            q.addLast(symA);
            q.addLast(symB);
        }
        return true;
    }
}

class Children {
    TreeNode left;
    TreeNode right;

    Children(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}

/**
 * Very important problem where we need to compare two trees
 */
