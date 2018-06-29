import java.util.Arrays;

// 561. Array Partition I
// https://leetcode.com/problems/array-partition-i/description/
class Solution561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
