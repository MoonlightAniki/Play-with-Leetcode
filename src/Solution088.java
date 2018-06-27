import java.util.Arrays;

// 88. Merge Sorted Array
// https://leetcode.com/problems/merge-sorted-array/description/
public class Solution088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m];//nums1的备份
        for (int i = 0; i < m; ++i) {
            copy[i] = nums1[i];
        }

        int i = 0;//copy数组中正在考察的元素
        int j = 0;//nums2数组中正在被考察的元素
        for (int k = 0; k < m + n; ++k) {
            if (i >= m) {
                nums1[k] = nums2[j];
                ++j;
            } else if (j >= n) {
                nums1[k] = copy[i];
                ++i;
            } else if (copy[i] <= nums2[j]) {
                nums1[k] = copy[i];
                ++i;
            } else {// copy[i] > nums2[j]
                nums1[k] = nums2[j];
                ++j;
            }
        }
    }

    public static void main(String[] args) {
        Solution088 s = new Solution088();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        s.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
