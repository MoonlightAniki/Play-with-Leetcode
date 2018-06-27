import java.util.Arrays;

// 26. Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class Solution026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = 1; //nums[0...k)中无重复元素
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[k - 1]) {
                nums[k] = nums[i];
                ++k;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution026 s = new Solution026();
        int[] nums1 = {1, 1, 2};
        System.out.println(s.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(s.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
