// 53. Maximum Subarray
// https://leetcode.com/problems/maximum-subarray/
public class Solution053 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len + 1];//sum[i]表示nums[0...i)的和
        sums[0] = 0;
        for (int i = 1; i <= len; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int min = sums[0];//遍历过程中检索到的最小的sums[i]
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= len; ++i) {
            result = Math.max(result, sums[i] - min);
            min = Math.min(min, sums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution053 s = new Solution053();
//        System.out.println(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(s.maxSubArray(new int[]{1}));
    }
}
// Runtime: 9 ms, faster than 80.22% of Java online submissions for Maximum Subarray.
