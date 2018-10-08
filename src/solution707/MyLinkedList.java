package solution707;

// 707. Design Linked List.
// https://leetcode.com/problems/design-linked-list/
class MyLinkedList {

    private static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this(val, null);
        }

        public Node() {
            this(0, null);
        }

        public Node(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("nums is empty.");
            }
            this.val = nums[0];
            Node cur = this;
            for (int i = 1; i < nums.length; ++i) {
                cur.next = new Node(nums[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            for (Node cur = this; cur != null; cur = cur.next) {
                res.append(cur.val).append("->");
            }
            res.append("NULL");
            return res.toString();
        }
    }

    public static void main(String[] args) {
//        Node node = new Node(new int[]{1, 3, 5, 7, 9});
//        System.out.println(node);
//
//        MyLinkedList list = new MyLinkedList();
//        for (int i = 0; i < 10; ++i) {
//            list.addAtTail(i);
//        }
//        System.out.println(list);
//        list.deleteAtIndex(0);
//        System.out.println(list);

        //["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        //[[],[1],[3],[1,2],[1],[1],[1]]
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        System.out.println(list);
        list.addAtTail(3);
        System.out.println(list);
        list.addAtIndex(1, 2);
        System.out.println(list);
        list.get(1);
        System.out.println(list);
        list.deleteAtIndex(1);
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list);
    }

    private Node dummyHead;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        dummyHead = new Node(-1);
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
//            throw new IllegalArgumentException("index is illegal.");
            return -1;
        }
        Node cur = dummyHead;
        for (int i = 0; i <= index; ++i) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
//            throw new IllegalArgumentException("index is illegal.");
            return;
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; ++i) {
            prev = prev.next;
        }
//        Node node = new Node(val);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(val, prev.next);
        ++size;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
//            throw new IllegalArgumentException("index is illegal.");
            return;
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; ++i) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        --size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("MyLinkedList, size:").append(size).append('\n');
        res.append(dummyHead.next);
        return res.toString();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

// Runtime: 94 ms, faster than 47.90% of Java online submissions for Design Linked List.
