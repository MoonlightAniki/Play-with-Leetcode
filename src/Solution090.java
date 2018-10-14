import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 090. Subsets II
// https://leetcode.com/problems/subsets-ii/
/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Solution090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; ++i) {
            generateSubset(nums, i, 0, res, new ArrayList<>());
        }
        return res;
    }

    private void generateSubset(int[] nums, int n, int start, List<List<Integer>> res, List<Integer> list) {
        if (n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            generateSubset(nums, n - 1, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution090 s = new Solution090();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
// Runtime: 4 ms, faster than 40.30% of Java online submissions for Subsets II.
