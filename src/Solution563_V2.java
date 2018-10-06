public class Solution563_V2 {
    private int tilt = 0;

    public int findTilt(TreeNode root) {
        tilt = 0;
        sum(root);
        return tilt;
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        tilt += Math.abs(leftSum - rightSum);
        return node.val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        Solution563_V2 s = new Solution563_V2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(s.findTilt(root));
    }
}
// Runtime: 8 ms, faster than 31.52% of Java online submissions for Binary Tree Tilt.
