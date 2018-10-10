import java.util.Arrays;

// 581. Shortest Unsorted Continuous Subarray
// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < arr.length && nums[l] == arr[l]) {
            ++l;
        }
        while (r >= 0 && nums[r] == arr[r]) {
            --r;
        }
        if (l >= r) {
            return 0;
        }

        return r - l + 1;
    }

    public static void main(String[] args) {
        Solution581 s = new Solution581();
        System.out.println(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(s.findUnsortedSubarray(new int[]{2, 4, 6, 8, 9, 10, 15}));
    }
}
// Runtime: 29 ms, faster than 26.73% of Java online submissions for Shortest Unsorted Continuous Subarray.
