// 543. Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/
/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Solution543 {

    private int max = 0;

    // 二叉树的直径等于所有节点中的左子树最大深度加上右子树最大深度的最大值
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    // 计算节点的最大深度
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        max = Math.max(max, left + right);// 递归过程中记录 max
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution543 s = new Solution543();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(s.diameterOfBinaryTree(root));
    }
}
// Runtime: 7 ms, faster than 40.48% of Java online submissions for Diameter of Binary Tree.
