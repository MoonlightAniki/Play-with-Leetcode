// 204. Count Primes
// https://leetcode.com/problems/count-primes/
/*
Count the number of prime numbers less than a non-negative number, n.

Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Solution204_V2 {

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (!notPrime[i]) {
                ++count;
                for (int j = 2; i * j < n; ++j) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution204_V2 s = new Solution204_V2();
        System.out.println(s.countPrimes(1500000));
    }
}
// Runtime: 22 ms, faster than 49.34% of Java online submissions for Count Primes.
