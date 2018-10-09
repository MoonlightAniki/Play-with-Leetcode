public class Solution035_V2 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution035 s = new Solution035();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5) == 2);
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2) == 1);
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0) == 0);
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7) == 4);
    }
}
// Runtime: 4 ms, faster than 58.12% of Java online submissions for Search Insert Position.
