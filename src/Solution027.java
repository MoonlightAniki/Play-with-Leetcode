import java.util.Arrays;

// 27. Remove Element
// https://leetcode.com/problems/remove-element/description/
public class Solution027 {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int k = 0;//nums[0...k)!=val
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                ++k;
            }
        }
        for (int i = k; i < nums.length; ++i) {
            nums[i] = val;
        }
        return k;
    }

    public static void main(String[] args) {
        Solution027 s = new Solution027();
        int[] nums1 = {3, 2, 2, 3};
        System.out.println(s.removeElement(nums1, 3));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(s.removeElement(nums2, 2));
        System.out.println(Arrays.toString(nums2));
    }
}
