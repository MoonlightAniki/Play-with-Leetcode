// 46. Permutations
// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Solution046 {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res.clear();
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        generatePermutation(nums, 1, stack);
        return res;
    }


    // index 表示当前正在正在往 stack 中添加第 index 个元素
    // stack 中已经保存了 index-1 个元素了
    private void generatePermutation(int[] nums, int index, Stack<Integer> stack) {
        // 所有的元素已经考察完毕，此时list中保存了一个合法的排列
//        System.out.println(index + " : " + stack);
        if (index == nums.length + 1) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!used[i]) {
                stack.push(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, stack);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution046 s = new Solution046();
        System.out.println(s.permute(new int[]{1, 2, 3}));
    }
}
// Runtime: 5 ms, faster than 29.69% of Java online submissions for Permutations.
