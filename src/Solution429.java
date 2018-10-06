import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 429. N-ary Tree Level Order Traversal
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/
public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<DepthNode> q = new LinkedList<>();
        q.offer(new DepthNode(root, 0));
        int currentDepth = 0;
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            DepthNode front = q.poll();
            if (front.depth != currentDepth) {
                result.add(list);
                list = new ArrayList<>();
                currentDepth = front.depth;
            }
            list.add(front.node.val);
            for (Node child : front.node.children) {
                if (child != null) {
                    q.offer(new DepthNode(child, currentDepth + 1));
                }
            }
        }
        result.add(list);
        return result;
    }

    private class DepthNode {
        private Node node;
        private int depth;

        public DepthNode(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
// Runtime: 10 ms, faster than 16.50% of Java online submissions for N-ary Tree Level Order Traversal.
