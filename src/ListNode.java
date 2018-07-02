public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; ++i) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (ListNode cur = this; cur != null; cur = cur.next) {
            res.append(cur.val).append("->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode node = new ListNode(nums);
        System.out.println(node);
    }
}