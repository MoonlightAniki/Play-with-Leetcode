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
public class Solution337_V2 {
    public int rob(TreeNode root) {
        return tryRob(root, new int[]{0, 0});
    }

    private int tryRob(TreeNode node, int[] lr) {
        if (node == null) {
            return 0;
        }
        int[] l_lr = new int[]{0, 0};
        int[] r_lr = new int[]{0, 0};
        lr[0] = tryRob(node.left, l_lr);
        lr[1] = tryRob(node.right, r_lr);
        return Math.max(node.val + l_lr[0] + l_lr[1] + r_lr[0] + r_lr[1], lr[0] + lr[1]);
    }
}
// Runtime: 1 ms, faster than 99.24% of Java online submissions for House Robber III.
