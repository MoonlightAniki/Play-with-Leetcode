// 23. Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/
public class Solution023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        while (checkKLists(lists)) {
            mergeKLists(lists, dummyHead);
        }
        return dummyHead.next;
    }

    private void mergeKLists(ListNode[] lists, ListNode dummyHead) {
        ListNode tail = dummyHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new ListNode(Integer.MAX_VALUE);
        tail = tail.next;
        int minIndex = -1;
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null && lists[i].val < tail.val) {
                tail.val = lists[i].val;
                minIndex = i;
            }
        }
        lists[minIndex] = lists[minIndex].next;
    }

    private boolean checkKLists(ListNode[] lists) {
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution023 s = new Solution023();
        ListNode[] lists = new ListNode[]{
                new ListNode(new int[]{1, 4, 5}),
                new ListNode(new int[]{1, 3, 4}),
                new ListNode(new int[]{2, 6})
        };
        ListNode head = s.mergeKLists(lists);
        System.out.println(head);
    }
}
