public class Solution136_V2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            result ^= nums[i];
        }
        return result;
    }
}
// Runtime: 1 ms, faster than 72.93% of Java online submissions for Single Number.
