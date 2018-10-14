import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 040. Combination Sum II
// https://leetcode.com/problems/combination-sum-ii/

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
public class Solution040 {

    private Set<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        generateCombination(candidates, 0, target, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void generateCombination(int[] nums, int start, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            generateCombination(nums, i + 1, target - nums[i], list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution040 s = new Solution040();
        System.out.println(s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
// Runtime: 109 ms, faster than 2.42% of Java online submissions for Combination Sum II.
