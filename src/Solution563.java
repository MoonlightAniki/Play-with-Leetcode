import java.util.HashMap;
import java.util.Map;

// 563. Binary Tree Tilt
// https://leetcode.com/problems/binary-tree-tilt/
public class Solution563 {
    private Map<TreeNode, Integer> record;
    private int tilt;


    public int findTilt(TreeNode root) {
        record = new HashMap<>();
        tilt = 0;
        preorder(root);
        return tilt;
    }

    private void preorder(TreeNode node) {
        if (node == null) return;
        preorder(node.left);
        tilt += Math.abs(sum(node.left) - sum(node.right));
        preorder(node.right);
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = 0;
        int rightSum = 0;
        if (node.left == null) {
            leftSum = 0;
        } else {
            Integer i = record.get(node.left);
            if (i != null) {
                leftSum = i;
            } else {
                leftSum = sum(node.left);
                record.put(node.left, leftSum);
            }
        }
        if (node.right == null) {
            rightSum = 0;
        } else {
            Integer i = record.get(node.right);
            if (i != null) {
                rightSum = i;
            } else {
                rightSum = sum(node.right);
                record.put(node.right, rightSum);
            }
        }
        int sum = node.val + leftSum + rightSum;
        record.put(node, sum);
        return sum;
    }

    public static void main(String[] args) {
        Solution563 s = new Solution563();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(s.findTilt(root));
    }
}
// Runtime: 19 ms, faster than 11.26% of Java online submissions for Binary Tree Tilt.
