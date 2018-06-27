import java.util.Arrays;

// 75. Sort Colors
// https://leetcode.com/problems/sort-colors/description/
public class Solution075 {
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                ++zero;
            } else if (nums[i] == 1) {
                ++one;
            } else if (nums[i] == 2) {
                ++two;
            }
        }
        int i;
        for (i = 0; i < zero; ++i) {
            nums[i] = 0;
        }
        for (i = zero; i < zero + one; ++i) {
            nums[i] = 1;
        }
        for (i = zero + one; i < zero + one + two; ++i) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        Solution075 s = new Solution075();
        int[] nums = {2, 0, 2, 1, 1, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
