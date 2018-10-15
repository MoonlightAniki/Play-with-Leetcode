import java.util.Arrays;

// 922. Sort Array By Parity II
// https://leetcode.com/problems/sort-array-by-parity-ii/
/*
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
You may return any answer array that satisfies this condition.

Example 1:
Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


Note:
1. 2 <= A.length <= 20000
2. A.length % 2 == 0
3. 0 <= A[i] <= 1000
 */
public class Solution922 {

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] res = new int[A.length];
        int odd = 1;
        int even = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                res[even] = A[i];
                even += 2;
            } else {
                res[odd] = A[i];
                odd += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution922 s = new Solution922();
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }
}
// Runtime: 7 ms, faster than 100.00% of Java online submissions for Sort Array By Parity II.
