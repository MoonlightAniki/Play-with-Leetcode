package solution155;

public class MinStack2 {

    private class StackNode {
        int val;
        int min;
        StackNode next;

        public StackNode(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    private StackNode top;

    public MinStack2() {

    }

    public void push(int x) {
        if (top == null) {
            top = new StackNode(x, x);
        } else {
            int min = Math.min(x, top.min);
            StackNode node = new StackNode(x, min);
            node.next = top;
            top = node;
        }
    }

    public void pop() {
        StackNode delNode = top;
        top = delNode.next;
        delNode.next = null;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }
}
// Runtime: 63 ms, faster than 98.63% of Java online submissions for Min Stack.
