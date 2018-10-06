import java.util.ArrayList;
import java.util.List;

// 589. N-ary Tree Preorder Traversal
// https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (Node child : node.children) {
            preorder(child, result);
        }
    }
}
// Runtime: 4 ms, faster than 78.33% of Java online submissions for N-ary Tree Preorder Traversal.
