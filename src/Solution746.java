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
public class Solution746 {
    private int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        return Math.min(minCost(cost, 0), minCost(cost, 1));
    }

    // 从start爬到台阶顶端的最小花费
    private int minCost(int[] cost, int start) {
//        System.out.println("start = " + start);
        // 已经爬到了台阶顶端
        if (start >= cost.length) {
            return 0;
        }
        // 在倒数第一个台阶或者倒数第二个台阶
        if (start == cost.length - 1 || start == cost.length - 2) {
            return cost[start];
        }
        if (memo[start] != 0) {
            return memo[start];
        }
        memo[start] = cost[start] + Math.min(
                minCost(cost, start + 1),//向上爬一步
                minCost(cost, start + 2)//向上爬2步
        );
        return memo[start];
    }

    public static void main(String[] args) {
        Solution746 s = new Solution746();
//        System.out.println(s.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
// Runtime: 15 ms, faster than 43.64% of Java online submissions for Min Cost Climbing Stairs.
