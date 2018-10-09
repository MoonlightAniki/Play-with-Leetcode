public class Solution053_V2 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxEndingHere = nums[0];//遍历过程中, nums中以i-1结束的连续的子数组的最大和
        int maxSoFar = nums[0];//遍历过程中，nums中最大的连续子数组和

        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
// Runtime: 9 ms, faster than 80.22% of Java online submissions for Maximum Subarray.
