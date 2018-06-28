import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1. Two Sum
// https://leetcode.com/problems/two-sum/description/
class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution001 s = new Solution001();
        int[] nums = {3, 2, 4};
        int[] result = s.twoSum(nums, 6);
        System.out.println(Arrays.toString(result));

        nums = new int[]{3, 3};
        System.out.println(Arrays.toString(s.twoSum(nums, 6)));
    }
}
