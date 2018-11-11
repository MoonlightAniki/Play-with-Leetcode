// 96. Unique Binary Search Trees
// https://leetcode.com/problems/unique-binary-search-trees/
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

public class Solution096 {
    // G(n)表示 [1...n] 能组成不同的 BST 的数量
    // F(i, n) 表示由 [1...n] 组成并且根节点为 i 的 BST 的数量
    // G(n) = F(1,n) + F(2,n) + ... + F(n-1,n) + F(n, n)
    // F(i, n) = G(i-1) * G(n-i)
    // ==> G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-2) * G(1) + G(n-1) * G(0)
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                g[i] += g[j] * g[i - 1 - j];
            }
        }
        return g[n];
    }

    public static void main(String[] args) {
        Solution096 s = new Solution096();
        System.out.println(s.numTrees(2));
        System.out.println(s.numTrees(3));
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
