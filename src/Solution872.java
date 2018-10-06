import java.util.ArrayList;
import java.util.List;

// 872. Leaf-similar Trees
// https://leetcode.com/problems/leaf-similar-trees/
public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return compareList(leaves1, leaves2);
    }

    private boolean compareList(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0, sz = a.size(); i < sz; ++i) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void getLeaves(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        if (node.left != null) {
            getLeaves(node.left, result);
        }
        if (node.right != null) {
            getLeaves(node.right, result);
        }
    }
}
// Runtime: 3 ms, faster than 70.65% of Java online submissions for Leaf-Similar Trees.
