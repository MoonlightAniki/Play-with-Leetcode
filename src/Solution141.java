import java.util.HashSet;
import java.util.Set;

// 141. Linked List Cycle.
// https://leetcode.com/problems/linked-list-cycle/
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (!set.add(cur)) {
                return true;
            }
        }
        return false;
    }
}
