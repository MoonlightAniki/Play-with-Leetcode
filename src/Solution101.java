// 101. Symmetric Tree
// https://leetcode.com/problems/symmetric-tree/
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return equals(root.left, mirror(root.right));
    }

    private TreeNode mirror(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode leftNode = mirror(node.right);
        TreeNode rightNode = mirror(node.left);
        node.left = leftNode;
        node.right = rightNode;
        return node;
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

    public static void main(String[] args) {
        Solution101 s = new Solution101();
        //        1
        //     /     \
        //    2       3
        //   / \    /  \
        //  3 null 2   null
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(2);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);

        System.out.println(s.isSymmetric(root));
    }
}
// Runtime: 8 ms, faster than 98.77% of Java online submissions for Symmetric Tree.
