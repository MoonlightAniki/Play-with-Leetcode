import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution429_V2 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while (!q.isEmpty()) {
            Pair<Node, Integer> front = q.poll();
            Node node = front.getKey();
            Integer level = front.getValue();
            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    q.offer(new Pair<>(child, level + 1));
                }
            }
        }
        return res;
    }
}
// Runtime: 14 ms, faster than 2.53% of Java online submissions for N-ary Tree Level Order Traversal.
