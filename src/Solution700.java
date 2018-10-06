// 700. Search in Binary Search Tree
// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {// val == root.val
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Solution700 s = new Solution700();
        TreeNode result = s.searchBST(root, 5);
        System.out.println(result);
    }
}
