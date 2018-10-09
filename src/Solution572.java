import java.util.LinkedList;
import java.util.Queue;

// 572. Subtree of Another Tree
// https://leetcode.com/problems/subtree-of-another-tree/
public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            TreeNode front = q.poll();
            if (equals(front, t)) {
                return true;
            }
            if (front.left != null) {
                q.offer(front.left);
            }
            if (front.right != null) {
                q.offer(front.right);
            }
        }
        return false;
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
// Runtime: 19 ms, faster than 48.10% of Java online submissions for Subtree of Another Tree.
