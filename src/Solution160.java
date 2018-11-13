import java.util.HashSet;
import java.util.Set;

// 160. Intersection of Linked Lists
// https://leetcode.com/problems/intersection-of-two-linked-lists/
/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> records = new HashSet<>();
        ListNode head = headA;
        while (head != null) {
            records.add(head);
            head = head.next;
        }
        head = headB;
        while (head != null) {
            if (records.contains(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
// Runtime: 13 ms, faster than 6.97% of Java online submissions for Intersection of Two Linked Lists.
