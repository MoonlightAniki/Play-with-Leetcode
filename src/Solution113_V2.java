import java.util.ArrayList;
import java.util.List;

// 113. Path Sum II
// https://leetcode.com/problems/path-sum-ii/
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class Solution113_V2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, sum, res, new ArrayList<>());
        return res;
    }

    private void pathSum(TreeNode node, int sum, List<List<Integer>> res, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new ArrayList<>(list));
        }

        pathSum(node.left, sum - node.val, res, list);
        pathSum(node.right, sum - node.val, res, list);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution113_V2 s = new Solution113_V2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(s.pathSum(root, 3));
    }
}
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
