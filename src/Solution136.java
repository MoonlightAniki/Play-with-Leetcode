import java.util.HashSet;
import java.util.Set;

// 136. Single Number
// https://leetcode.com/problems/single-number/
public class Solution136 {
    public int singleNumber(int[] nums) {
        Set<Integer> record = new HashSet<>();
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (record.contains(nums[i])) {
                record.remove(nums[i]);
            } else {
                record.add(nums[i]);
            }
        }
        return record.iterator().next();
    }

    public static void main(String[] args) {
        Solution136 s = new Solution136();
        System.out.println(s.singleNumber(new int[]{2, 1, 1}));
    }
}
// Runtime: 20 ms, faster than 11.68% of Java online submissions for Single Number.
