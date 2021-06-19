public class ClosestLeafNode_LC742 {
    int ans = -1;

    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null)
            return 0;
        dfs(root, k);
        return ans;
    }

    private NodeInfo dfs(TreeNode root, int target) {
        if (root == null)
            return null;
        NodeInfo l = dfs(root.left, target);
        NodeInfo r = dfs(root.right, target);
        if (root.val == target) {
            // Case A - I'm the answer
            if (l == null && r == null) {
                ans = root.val;
            }
            // Case B - One of my children is NULL and the non-null children is ans
            else if (l == null || r == null) {
                ans = l == null ? r.leafVal : l.leafVal;
            } else {
                // Case C - Both my children are NOT null
                if (l.dist < r.dist) {
                    ans = l.leafVal;
                } else {
                    ans = r.leafVal;
                }
            }
        } else {
            // Case - I'm NOT the target node and I'm the lead
            if (l == null && r == null)
                return new NodeInfo(0, root.val);
            else if (l == null || r == null) {
                // grab the non-null node, increment the dist by 1 and return
                NodeInfo nxt = l == null ? new NodeInfo(r.dist + 1, r.leafVal) : new NodeInfo(l.dist + 1, l.leafVal);
                return nxt;
            } else {
                // Both are non null
                if (l.dist < r.dist) {
                    return new NodeInfo(l.dist + 1, l.leafVal);
                }
                return new NodeInfo(r.dist + 1, r.leafVal);
            }
        }
        return null;
    }

}

class NodeInfo {
    int dist;
    int leafVal;

    NodeInfo(int dist, int leafVal) {
        this.dist = dist;
        this.leafVal = leafVal;
    }

}
