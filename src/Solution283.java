import java.util.Arrays;

// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/description/
public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int k = 0;// nums[0...k)!=0
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                ++k;
            }
        }
        for (int i = k; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution283 s = new Solution283();
        int[] nums = {0, 1, 0, 2, 0, 0, 3, 4, 0};
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
