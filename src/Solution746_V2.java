// 746. Min Cost Climbing Stairs
// https://leetcode.com/problems/min-cost-climbing-stairs/
/*
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

Note:
    1. cost will have a length in the range [2, 1000].
    2. Every cost[i] will be an integer in the range [0, 999].
 */
public class Solution746_V2 {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }

        // cost.length >= 2
        int[] memo = new int[n];//memo[index]表示从index爬到顶端的最小花费，Math.min(memo[0], memo[1])就是问题的解
        memo[n - 1] = cost[n - 1];
        memo[n - 2] = cost[n - 2];
        for (int i = n - 3; i >= 0; --i) {
            memo[i] = cost[i] + Math.min(memo[i + 1], memo[i + 2]);
        }
        return Math.min(memo[0], memo[1]);
    }

    public static void main(String[] args) {
        Solution746_V2 s = new Solution746_V2();
//        System.out.println(s.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
// Runtime: 11 ms, faster than 99.23% of Java online submissions for Min Cost Climbing Stairs.
