// 204. Count Primes
// https://leetcode.com/problems/count-primes/
/*
Count the number of prime numbers less than a non-negative number, n.

Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Solution204 {

    // Time Limit Exceeded
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime(i)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution204 s = new Solution204();
        System.out.println(s.countPrimes(1500000));
    }
}
