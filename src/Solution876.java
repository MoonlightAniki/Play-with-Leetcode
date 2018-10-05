// 876. Middle of the Linked List.
// https://leetcode.com/problems/middle-of-the-linked-list/
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            ++count;
        }
        ListNode mid = head;
        for (int i = 0; i < count / 2; ++i) {
            mid = mid.next;
        }
        return mid;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 2, 3, 4, 5});
        Solution876 s = new Solution876();
        System.out.println(s.middleNode(node));
    }
}
