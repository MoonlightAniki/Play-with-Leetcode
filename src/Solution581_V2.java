public class Solution581_V2 {

    //
    // search from left for the first index whose value is less than
    // the max so far. it is the right index.
    //
    // search from right for the first index whose value is more than
    // the min so far. it is the left index.
    //
    // One-pass
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;

        int left = n - 1, right = 0;
        int min = nums[n - 1], max = nums[0];
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            if (nums[i] > min) left = i;
            if (nums[j] < max) right = j;
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[j]);
        }

        return (left < right ? right - left + 1 : 0);
    }

    public static void main(String[] args) {
        Solution581_V2 s = new Solution581_V2();
        System.out.println(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(s.findUnsortedSubarray(new int[]{2, 4, 6, 8, 9, 10, 15}));
    }
}
