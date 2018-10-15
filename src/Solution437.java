// 437. Path Sum III
// https://leetcode.com/problems/path-sum-iii/
/*
You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:
1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class Solution437 {

    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        preOrder(root, sum);
        return count;
    }

    private void preOrder(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        count += pathSumFrom(node, sum);
        preOrder(node.left, sum);
        preOrder(node.right, sum);
    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(-3);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(3);
//        root.left.left.right = new TreeNode(-2);
//        root.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(1);
//        root.right.right = new TreeNode(11);
//        Solution437 s = new Solution437();
//        System.out.println(s.pathSum(root, 8));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);
        Solution437 s = new Solution437();
        System.out.println(s.pathSum(root, -1));
    }
}
// Runtime: 16 ms, faster than 71.65% of Java online submissions for Path Sum III.
