// 654. Maximum Binary Tree
// https://leetcode.com/problems/maximum-binary-tree/
public class Solution654 {

    /*
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    // Version 1
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//
//        if (nums.length == 1) {
//            return new TreeNode(nums[0]);
//        }
//
//        int maxIndex = 0;
//        for (int i = 1; i < nums.length; ++i) {
//            if (nums[i] > nums[maxIndex]) {
//                maxIndex = i;
//            }
//        }
//
//        TreeNode result = new TreeNode(nums[maxIndex]);
//        result.left = maxIndex == 0 ? null : constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
//        result.right = maxIndex == nums.length - 1 ? null : constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
//
//        return result;
//    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        int l = 0;
        int r = nums.length - 1;
        return constructMaximumBinaryTree(nums, l, r);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l > r) return null;

        int maxIndex = l;
        for (int i = l + 1; i <= r; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructMaximumBinaryTree(nums, l, maxIndex - 1);
        node.right = constructMaximumBinaryTree(nums, maxIndex + 1, r);

        return node;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        int[] nums = new int[]{3, 2, 1, 6, 0, 9};
//        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 2)));
        TreeNode treeNode = new Solution654().constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }
}
