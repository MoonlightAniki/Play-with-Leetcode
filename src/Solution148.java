import java.util.PriorityQueue;

// 148. Sort List
// https://leetcode.com/problems/sort-list/
public class Solution148 {

    // 使用优先队列
    // Time Comlexity : O(n^2)
    // Space Comlexity : O(n)
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            pq.offer(cur.val);
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (!pq.isEmpty()) {
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        Solution148 s = new Solution148();
        System.out.println(s.sortList(new ListNode(new int[]{1, 3, 2, 5, 4})));
    }
}
// Runtime: 11 ms, faster than 15.56% of Java online submissions for Sort List.
