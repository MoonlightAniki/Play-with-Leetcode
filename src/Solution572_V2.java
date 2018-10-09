public class Solution572_V2 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
//        if (equals(s, t)) {
//            return true;
//        }
        if (s.val == t.val) {
            if (equals(s, t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return equals(node1.left, node2.left) && equals(node1.right, node2.right);
    }
}
// Runtime: 21 ms, faster than 39.36% of Java online submissions for Subtree of Another Tree.
