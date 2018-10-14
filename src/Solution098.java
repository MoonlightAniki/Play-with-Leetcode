import java.util.ArrayList;
import java.util.List;

// 098. Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true

Example 2:
    5
   / \
  1   4
     / \
    3   6
Output: false

Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 */
public class Solution098 {
    // 思路错误
    // [10,5,15,null,null,6,20]
    //             10
    //            /  \
    //           5   15
    //              /  \
    //             6   20
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        TreeNode leftNode = root.left;
//        TreeNode rightNode = root.right;
//        if (leftNode == null && rightNode == null) {
//            return true;
//        }
//        if (leftNode == null /* && rightNode != null*/) {
//            return root.val < rightNode.val && isValidBST(rightNode);
//        }
//        if (rightNode == null /* && leftNode != null */) {
//            return root.val > leftNode.val && isValidBST(leftNode);
//        }
//        // leftNode != null && rightNode != null
//        return root.val > leftNode.val && root.val < rightNode.val && isValidBST(leftNode) && isValidBST(rightNode);
//    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> record = new ArrayList<>();
        inorder(root, record);

        for (int i = 0; i + 1 < record.size(); ++i) {
            if (record.get(i) >= record.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode node, List<Integer> record) {
        if (node == null) {
            return;
        }
        inorder(node.left, record);
        record.add(node.val);
        inorder(node.right, record);
    }
}
// Runtime: 2 ms, faster than 31.41% of Java online submissions for Validate Binary Search Tree.