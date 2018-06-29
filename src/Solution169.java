import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 169. Majority Element
// https://leetcode.com/problems/majority-element/description/
class Solution169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) + 1 > nums.length / 2) {
                return num;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        throw new IllegalArgumentException("No Solution!");
    }

    public static void main(String[] args) {
        Solution169 s = new Solution169();
        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(s.majorityElement(nums1));
    }
}
