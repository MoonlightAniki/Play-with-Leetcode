import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15. 3Sum
// https://leetcode.com/problems/3sum/description/
class Solution015 {
    // 暴力解法
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (nums == null || nums.length < 3) {
//            return list;
//        }
//        for (int i = 0; i < nums.length; ++i) {
//            for (int j = i + 1; j < nums.length; ++j) {
//                for (int k = j + 1; k < nums.length; ++k) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> l = new ArrayList<>();
//                        l.add(nums[i]);
//                        l.add(nums[j]);
//                        l.add(nums[k]);
//                        Collections.sort(l);
//                        if (!list.contains(l)) {
//                            list.add(l);
//                        }
//                    }
//                }
//            }
//        }
//        return list;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
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
                if (a + b + c == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(a);
                    l.add(b);
                    l.add(c);
                    list.add(l);
                    // 跳过重复的结果
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (high > low && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (a + b + c < 0) {
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    low++;
                } else {// a + b + c > 0
                    while (high > low && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    high--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution015 s = new Solution015();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(nums));
    }
}
