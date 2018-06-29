import java.util.HashSet;
import java.util.Set;

// 217. Contains Duplicate
// https://leetcode.com/problems/contains-duplicate/description/
class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution217 s = new Solution217();
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
