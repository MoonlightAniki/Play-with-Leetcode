import java.util.Comparator;
import java.util.PriorityQueue;

// 23. Merge K Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/
public class Solution023_V2 {
    // 使用优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            prev.next = node;
            prev = prev.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution023_V2 s = new Solution023_V2();
        ListNode[] lists = new ListNode[]{
                new ListNode(new int[]{1, 3, 4}),
                new ListNode(new int[]{1, 2, 5}),
                new ListNode(new int[]{2, 4})
        };
        System.out.println(s.mergeKLists(lists));
    }
}
