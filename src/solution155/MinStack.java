package solution155;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

// 155. Min Stack
// https://leetcode.com/problems/min-stack/
public class MinStack {

    private List<Pair<Integer, Integer>> data;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        min = Math.min(min, x);
        data.add(new Pair<>(x, min));
    }

    public void pop() {
        if (data.size() == 0) {
            return;
        }
        data.remove(data.size() - 1);
        if (data.size() == 0) {
            min = Integer.MAX_VALUE;
        } else {
            min = data.get(data.size() - 1).getValue();
        }
    }

    public int top() {
        return data.get(data.size() - 1).getKey();
    }

    public int getMin() {
        return data.get(data.size() - 1).getValue();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
// Runtime: 65 ms, faster than 95.30% of Java online submissions for Min Stack.

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
