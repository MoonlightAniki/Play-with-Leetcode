public class Solution121_V2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < n; ++i) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution121_V2 s = new Solution121_V2();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5);
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0);
    }
}
// Runtime: 3 ms, faster than 20.19% of Java online submissions for Best Time to Buy and Sell Stock.
