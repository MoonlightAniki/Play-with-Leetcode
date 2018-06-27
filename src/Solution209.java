// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = -1;
        int sum = 0;//nums[left...right]中元素的和,滑动窗口

        int minLen = Integer.MAX_VALUE;
        while (right < nums.length && left < nums.length) {
//            if (sum >= s) {
//                if (minLen > right - left + 1) {
//                    minLen = right - left + 1;
//                }
//                sum -= nums[left];
//                ++left;
//            } else {//sum < s
//                if (right + 1 == nums.length) {
//                    break;
//                }
//                sum += nums[right + 1];
//                ++right;
//            }
            if (sum < s && right + 1 < nums.length) {
                ++right;
                sum += nums[right];
            } else {
                sum -= nums[left];
                ++left;
            }
            if (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution209 s = new Solution209();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(s.minSubArrayLen(7, nums));
    }
}
