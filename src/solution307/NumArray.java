package solution307;

// 307. Range Sum Query - Mutable
// https://leetcode.com/problems/range-sum-query-mutable/
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.

Example:
Given nums = [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 */

public class NumArray {
    private class Node {
        int start, end;
        int val;
        Node left, right;

        Node(int val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }
    }

    private Node root;
    private int[] data;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        data = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            data[i] = nums[i];
        }
        root = buildSegmentTree(0, nums.length - 1);
    }

    private Node buildSegmentTree(int start, int end) {
        if (start == end) {
            return new Node(data[start], start, end);
        }
        int mid = start + (end - start) / 2;
        Node left = buildSegmentTree(start, mid);
        Node right = buildSegmentTree(mid + 1, end);
        Node node = new Node(left.val + right.val, start, end);
        node.left = left;
        node.right = right;
        return node;
    }

    public void update(int index, int val) {
        data[index] = val;
        root = update(root, index, val);
    }

    private Node update(Node node, int index, int val) {
        if (node.start == node.end) {
            node.val = val;
            return node;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (index > mid) {
            node.right = update(node.right, index, val);
        } else if (index <= mid) {
            node.left = update(node.left, index, val);
        }
        node.val = node.left.val + node.right.val;
        return node;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(Node node, int i, int j) {
        if (node.start == i && node.end == j) {
            return node.val;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (i >= mid + 1) {
            return sumRange(node.right, i, j);
        } else if (j <= mid) {
            return sumRange(node.left, i, j);
        } else {
            int left = sumRange(node.left, i, mid);
            int right = sumRange(node.right, mid + 1, j);
            return left + right;
        }
    }
}
// Runtime: 84 ms, faster than 55.09% of Java online submissions for Range Sum Query - Mutable.
