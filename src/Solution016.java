import java.util.Arrays;

// 16. 3Sum Closest
// https://leetcode.com/problems/3sum-closest/description/
class Solution016 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int b = nums[low];
                int c = nums[high];
                if (a + b + c == target) {
                    return target;
                } else if (a + b + c < target) {
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    low++;
                    int r = target - (a + b + c);
                    if (r < min) {
                        min = r;
                        result = a + b + c;
                    }
                } else {// a + b + c > target
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    high--;
                    int r = a + b + c - target;
                    if (r < min) {
                        min = r;
                        result = a + b + c;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution016 s = new Solution016();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(s.threeSumClosest(nums, 1));

        int[] nums2 = {0, 1, 2};
        System.out.println(s.threeSumClosest(nums2, 3));
    }
}
