import java.util.Arrays;

// 80. Remove Duplicates from Sorted Array II
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
public class Solution080 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = 1;//nums[0...k)满足条件
        int dups = 1;//arr[k-1]重复的次数
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[k - 1]) {
                dups = 1;
                nums[k] = nums[i];
                ++k;
            } else {// nums[i] == nums[k-1]
                ++dups;
                if (dups <= 2) {
                    nums[k] = nums[i];
                    ++k;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution080 s = new Solution080();
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println(s.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(s.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
