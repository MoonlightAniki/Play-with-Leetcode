import java.util.ArrayList;
import java.util.List;

// 114. Flatten Binary Tree to Linked List.
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class Solution114 {
    public void flatten(TreeNode root) {
        List<Integer> record = new ArrayList<>();
        preOrder(root, record);
        if (record.size() <= 1) {
            return;
        }
        TreeNode cur = root;
        cur.left = null;
        for (int i = 1, sz = record.size(); i < sz; ++i) {
            cur.right = new TreeNode(record.get(i));
            cur=cur.right;
        }
    }

    private void preOrder(TreeNode node, List<Integer> record) {
        if (node == null) {
            return;
        }
        record.add(node.val);
        preOrder(node.left, record);
        preOrder(node.right, record);
    }
}
// Runtime: 14 ms, faster than 23.48% of Java online submissions for Flatten Binary Tree to Linked List.
