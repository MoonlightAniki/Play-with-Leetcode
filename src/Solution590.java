import java.util.ArrayList;
import java.util.List;

// 590. N-ary Tree Postorder Traversal
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
public class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorder(root, result);
        return result;
    }

    private void postorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            postorder(child, result);
        }
        result.add(node.val);
    }

}
// Runtime: 3 ms, faster than 98.58% of Java online submissions for N-ary Tree Postorder Traversal.
