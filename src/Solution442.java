import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array
// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int[] record = new int[nums.length + 1];
        for (int num : nums) {
            record[num]++;
        }
        for (int i = 1; i < record.length; ++i) {
            if (record[i] >= 2) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution442 s = new Solution442();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(s.findDuplicates(nums));
    }
}
