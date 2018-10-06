import java.util.ArrayList;
import java.util.List;

// 897. Increasing Order Search Tree
// https://leetcode.com/problems/increasing-order-search-tree/
public class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        if (result.size() == 0) return null;
        TreeNode retNode = new TreeNode(result.get(0));
        TreeNode cur = retNode;
        for (int i = 1; i < result.size(); ++i) {
            cur.right = new TreeNode(result.get(i));
            cur = cur.right;
        }
        return retNode;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
// Runtime: 51 ms, faster than 32.07% of Java online submissions for Increasing Order Search Tree.
