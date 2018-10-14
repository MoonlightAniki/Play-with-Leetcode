import java.util.ArrayList;
import java.util.List;

// 077. Combinations
// https://leetcode.com/problems/combinations/
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Solution077 {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        generateCombination(n, k, 1, new ArrayList<>());
        return res;
    }


    // index 表示当前正在被考虑的数字
    // list 中保存了 [1...index-1] 这些数字组成的组合
    private void generateCombination(int n, int k, int index, List<Integer> list) {
//        System.out.println("n = " + n + ", k = " + k + ", index = " + index + ", list : " + list);
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; ++i) {
            list.add(i);
            generateCombination(n, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution077 s = new Solution077();
        System.out.println(s.combine(4, 3));
    }
}
// Runtime: 72 ms, faster than 16.18% of Java online submissions for Combinations.

// Runtime: 2 ms, faster than 99.96% of Java online submissions for Combinations.
