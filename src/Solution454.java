import java.util.HashMap;
import java.util.Map;

// 454. 4Sum II
// https://leetcode.com/problems/4sum-ii/
/*
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and
the result is guaranteed to be at most 231 - 1.

Example:
Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
    1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        int n = A.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = A[i] + B[j];
                freq1.put(sum, freq1.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = C[i] + D[j];
                freq2.put(sum, freq2.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
            res += entry.getValue() * freq2.getOrDefault(-entry.getKey(), 0);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution454 s = new Solution454();
        int res = s.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
        );
        System.out.println(res);
    }
}
// Runtime: 236 ms, faster than 8.53% of Java online submissions for 4Sum II.
