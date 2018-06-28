import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18. 4Sum
// https://leetcode.com/problems/4sum/description/
class Solution018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int c = nums[low];
                    int d = nums[high];
                    if (a + b + c + d == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        list.add(d);
                        result.add(list);
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (a + b + c + d < target) {
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        low++;
                    } else {// a + b + c + c > target
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution018 s = new Solution018();
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(s.fourSum(nums, 0));
    }
}
