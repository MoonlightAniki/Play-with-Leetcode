import java.util.ArrayList;
import java.util.List;

// 078. Subsets
// https://leetcode.com/problems/subsets/
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Solution078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        for (int i = 0; i <= nums.length; ++i) {
            generateSubset(nums, i, 0, res, new ArrayList<>());
        }
        return res;
    }

    // 从 nums[start...nums.length-1] 中取出 n 个元素
    private void generateSubset(int[] nums, int n, int start, List<List<Integer>> res, List<Integer> list) {
        if (n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            generateSubset(nums, n - 1, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution078 s = new Solution078();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
        System.out.println(s.subsets(new int[]{3, 1, 2}));
    }
}
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Subsets.
