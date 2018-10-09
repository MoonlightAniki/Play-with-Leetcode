// 035. Search Insertion Position
// https://leetcode.com/problems/search-insert-position/
public class Solution035 {

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    // 在 nums[l...r] 范围内查找等于 target 的元素的索引
    private int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return l;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, r, target);
        } else {
            return binarySearch(nums, l, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        Solution035 s = new Solution035();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5) == 2);
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2) == 1);
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0) == 0);
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7) == 4);
    }
}
// Runtime: 6 ms, faster than 14.68% of Java online submissions for Search Insert Position.
