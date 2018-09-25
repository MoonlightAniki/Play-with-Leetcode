import java.util.Arrays;

// 198. House Robber
// https://leetcode.com/problems/house-robber/description/
public class Solution198 {
    // 记忆化搜索+递归
    private int[] memo;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        memo = new int[nums.length];//memo[i]代表tryRob(nums, i)
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    // 考虑从nums[index...n-1]中偷取
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        memo[index] = Math.max(nums[index] + tryRob(nums, index + 2),//偷取i并考虑从nums[i+2...n-1]中偷取
                tryRob(nums, index + 1)//不偷取i，考虑从nums[i+1...n-1]中偷取
        );
        return memo[index];
    }

    public static void main(String[] args) {
        Solution198 s = new Solution198();
//        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(s.rob(nums));
    }
}
