// 213. House Robber II
// https://leetcode.com/problems/house-robber-ii/
public class Solution213 {

    // 记忆化搜索+递归
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
////        if (nums.length == 1) {
////            return nums[0];
////        }
////        if (nums.length == 2) {
////            return Math.max(nums[0], nums[1]);
////        }
//        int[] memo1 = new int[nums.length];
//        int[] memo2 = new int[nums.length];
//        Arrays.fill(memo1, -1);
//        Arrays.fill(memo2, -1);
//        return Math.max(tryRob(nums, 1, nums.length - 1, memo1),//不偷取index=0的房子
//                tryRob(nums, 2, nums.length - 2, memo2) + nums[0]//偷取index=0的房子
//        );
//    }
//
//    // 考虑从nums[begin...end]中偷取
//    private int tryRob(int[] nums, int begin, int end, int[] memo) {
//        if (begin > end) {
//            return 0;
//        }
//        if (memo[begin] != -1) {
//            return memo[begin];
//        }
//
//        int max = Math.max(nums[begin] + tryRob(nums, begin + 2, end, memo), tryRob(nums, begin + 1, end, memo));
//        memo[begin] = max;
//        return max;
//    }

    // 动态规划
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(tryRob(nums, 0, nums.length - 2), tryRob(nums, 1, nums.length - 1));
    }

    // 考虑从nums[begin...end]中偷取
    private int tryRob(int nums[], int begin, int end) {
        if (begin > end) return 0;
        int preMax = nums[begin];
        int curMax = Math.max(preMax, nums[begin + 1]);
        for (int i = begin + 2; i <= end; ++i) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + nums[i]);
            preMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        Solution213 s = new Solution213();
        int[] nums = new int[]{2, 3, 2, 1, 4};
        System.out.println(s.rob(nums));
    }
}
