// 485. Max Consecutive Ones
// https://leetcode.com/problems/max-consecutive-ones/description/
class Solution485 {
    public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;//nums[left...right)中元素全是1
        int max = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == 1) {
                ++right;
            }
            if (max < right - left) {
                max = right - left;
            }
            if (right == nums.length) {
                break;
            }
            ++right;
            left = right;
        }
        return max;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;//nums[left...right)中元素都是1
        int max = right - left + 1;
        while (right < nums.length) {
            if (nums[right] == 1) {
                ++right;
                if (right == nums.length) {
                    if (right - left > max) {
                        max = right - left;
                    }
                }
            } else {
                if (right - left > max) {
                    max = right - left;
                }
                ++right;
                left = right;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution485 s = new Solution485();
        int[] bits = {1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1};
        System.out.println(s.findMaxConsecutiveOnes(bits));
    }
}
