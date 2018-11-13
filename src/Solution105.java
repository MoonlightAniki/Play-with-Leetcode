// 105. Construct Binary Tree from Preorder and Inorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preorderL, int preorderR,
                               int[] inorder, int inorderL, int inorderR) {
        if (preorderL > preorderR) {
            return null;
        }
        if (preorderL == preorderR) {
            return new TreeNode(preorder[preorderL]);
        }

        TreeNode node = new TreeNode(preorder[preorderL]);
        int index = inorderL;
        for (; index <= inorderR; ++index) {
            if (inorder[index] == node.val) {
                break;
            }
        }
        // 左子树的节点数 index - inorderL
        // 右子树的节点数 inorderR - index
        node.left = buildTree(preorder, preorderL + 1, preorderL + index - inorderL, inorder, inorderL, index - 1);
        node.right = buildTree(preorder, preorderL + index - inorderL + 1, preorderR, inorder, index + 1, inorderR);
        return node;
    }
}
// Runtime: 26 ms, faster than 16.27% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
