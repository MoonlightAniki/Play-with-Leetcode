import java.util.Arrays;

// 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/
public class Solution238 {

    // Time Limit Exceeded
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int product = 1;
            for (int j = 0; j < nums.length; ++j) {
                if (j == i) continue;
                product *= nums[j];
            }
            result[i] = product;
        }
        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // 一轮循环结束后, res[i] 等于 nums[0...i-1] 的乘积 (res[0]=1)
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;//此时 right 等于 nums[i+1...n-1] 的乘积 (i+1 > n-1 时 right 等于1)
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution238 s = new Solution238();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
