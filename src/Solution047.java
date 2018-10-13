import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// 047. Permutations II
// https://leetcode.com/problems/permutations-ii/

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class Solution047 {
    private Set<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(res);
        }
        used = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        generatePermutation(nums, 0, stack);
        return new ArrayList<>(res);
    }

    private void generatePermutation(int[] nums, int index, Stack<Integer> stack) {
        if (index == nums.length) {
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
        Solution047 s = new Solution047();
        System.out.println(s.permuteUnique(new int[]{1, 1, 2}));
    }
}
// Runtime: 126 ms, faster than 10.61% of Java online submissions for Permutations II.
