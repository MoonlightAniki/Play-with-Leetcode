// 142. Linked List Cycle II
// https://leetcode.com/problems/linked-list-cycle-ii/
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 */

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 链表头到环的起点的距离为L，slow在环上移动的距离为S，fast在环上移动的距离为F
        // 2*(L+S) = L+F
        // 环的周长为C
        // F-S = n*C
        // 以上可以推出 L = (n-1)*C + (C-S)
        // fast与slow的交点到环的起点的距离等于L
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
