import java.util.ArrayList;
import java.util.List;

// 216. Combination Sum III
// https://leetcode.com/problems/combination-sum-iii/
/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 || k > n) {
            return res;
        }
        generateCombination(k, n, 1, res, new ArrayList<>());
        return res;
    }

    private void generateCombination(int k, int n, int start, List<List<Integer>> res, List<Integer> list) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; ++i) {
            list.add(i);
            generateCombination(k - 1, n - i, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution216 s = new Solution216();
        System.out.println(s.combinationSum3(3, 9));
        System.out.println(s.combinationSum3(3, 7));
    }
}
// Runtime: 2 ms, faster than 14.99% of Java online submissions for Combination Sum III.
