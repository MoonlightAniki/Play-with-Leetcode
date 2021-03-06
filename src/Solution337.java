// 336. House Robber III
// https://leetcode.com/problems/house-robber-iii/
/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class Solution337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxIncludeRoot = root.val;
        int maxExclueeRoot = 0;
        if (root.left != null) {
            maxIncludeRoot += rob(root.left.left) + rob(root.left.right);
            maxExclueeRoot += rob(root.left);
        }
        if (root.right != null) {
            maxIncludeRoot += rob(root.right.left) + rob(root.right.right);
            maxExclueeRoot += rob(root.right);
        }
        return Math.max(maxIncludeRoot, maxExclueeRoot);
    }
}
// Runtime: 504 ms, faster than 31.32% of Java online submissions for House Robber III.
