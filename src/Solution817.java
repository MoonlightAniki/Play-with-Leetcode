import java.util.HashSet;
import java.util.Set;

// 817. Linked List Components
// https://leetcode.com/problems/linked-list-components/
public class Solution817 {
    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null || G.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; ++i) {
            set.add(G[i]);
        }

        boolean prevContains = false;
        int numComponents = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            boolean curContains = set.contains(cur.val);
            if (!prevContains && curContains) {
                ++numComponents;
            }
            prevContains = curContains;
        }
        return numComponents;
    }

    public static void main(String[] args) {
        Solution817 s = new Solution817();
        System.out.println(s.numComponents(new ListNode(new int[]{0, 1, 2, 3, 4}), new int[]{0, 1, 3, 4}));
        System.out.println(s.numComponents(new ListNode(new int[]{0, 1, 2, 3, 4}), new int[]{0, 1, 3}));
    }
}
