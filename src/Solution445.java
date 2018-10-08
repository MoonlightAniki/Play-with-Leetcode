import java.util.Stack;

// 445. Add Two Numbers II
// https://leetcode.com/problems/add-two-numbers-ii/
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        numStack(l1, stack1);
        Stack<Integer> stack2 = new Stack<>();
        numStack(l2, stack2);

        int overflow = 0;
        Stack<Integer> result = new Stack<>();
        while (true) {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                break;
            }
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + overflow;
            result.push(sum % 10);
            overflow = sum / 10;
        }
        if (overflow > 0) {
            result.push(overflow);
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (!result.isEmpty()) {
            cur.next = new ListNode(result.pop());
            cur=cur.next;
        }
        return dummyHead.next;
    }

    private void numStack(ListNode node, Stack<Integer> stack) {
        if (node == null) return;
        for (ListNode cur = node; cur != null; cur = cur.next) {
            stack.push(cur.val);
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        Solution445 s = new Solution445();
        System.out.println(s.addTwoNumbers(l1, l2));
    }
}
// Runtime: 40 ms, faster than 36.83% of Java online submissions for Add Two Numbers II.
