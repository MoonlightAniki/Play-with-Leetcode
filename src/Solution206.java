import java.util.Stack;

// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/
/*
Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Solution206 {

    // 使用辅助数据结构(Stack)
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            stack.push(cur.val);
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution206 s = new Solution206();
        System.out.println(s.reverseList(new ListNode(new int[]{1, 2, 3, 4, 5})));
    }
}
// Runtime: 2 ms, faster than 4.11% of Java online submissions for Reverse Linked List.
