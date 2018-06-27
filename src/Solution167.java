import java.util.Arrays;

// 167. Two Sum II - Input array is sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        int len = numbers.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            } else if (sum < target) {
                ++i;
            } else {// sum > target
                --j;
            }
        }
        if (i >= j) {
            return new int[0];
        } else {
            return new int[]{i + 1, j + 1};
        }
    }

    public static void main(String[] args) {
        Solution167 s = new Solution167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = s.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
}
