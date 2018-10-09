// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Solution121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution121 s = new Solution121();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0);
    }
}
// Runtime: 857 ms, faster than 0.99% of Java online submissions for Best Time to Buy and Sell Stock.
