// 814. Binary Tree Pruning
// https://leetcode.com/problems/binary-tree-pruning/
public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        if (root.left == null && root.right == null) {
            if (root.val == 1) {
                return root;
            } else {
                return null;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        Solution814 s = new Solution814();
        TreeNode result = s.pruneTree(root);
        System.out.println(result);
    }
}
