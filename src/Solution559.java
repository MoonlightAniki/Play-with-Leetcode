// 559. Maximum Depth of N-ary Tree
// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return 1 + max;
    }
}
// Runtime: 4 ms, faster than 55.26% of Java online submissions for Maximum Depth of N-ary Tree.
