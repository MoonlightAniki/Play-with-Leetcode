import java.util.ArrayList;
import java.util.List;

// 448. Find All Numbers Disappeared in an Array
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        boolean[] marked = new boolean[nums.length+1];
        for (int num : nums) {
            marked[num] = true;
        }
        for (int i = 1; i < marked.length; ++i) {
            if (!marked[i]) {
                list.add(i);
            }
        }
        return list;
    }



    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        shellSort(nums);
        for (int i = 1; i <= nums.length; ++i) {
            if (binarySearch(nums, i) == -1) {
                list.add(i);
            }
        }
        return list;
    }

    private void shellSort(int[] nums) {
        int h = 1;
        while (h < nums.length / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < nums.length; ++i) {
                int e = nums[i];
                int j;
                for (j = i; j - h >= 0 && nums[j - h] > e; j -= h) {
                    nums[j] = nums[j - h];
                }
                nums[j] = e;
            }
            h /= 3;
        }
    }

    private int binarySearch(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        return binarySearch(nums, l, r, t);
    }

    // 在nums[l...r]中查找t
    private int binarySearch(int[] nums, int l, int r, int t) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (t == nums[mid]) {
            return mid;
        } else if (t > nums[mid]) {
            return binarySearch(nums, mid + 1, r, t);
        } else {
            return binarySearch(nums, l, mid - 1, t);
        }
    }

    public static void main(String[] args) {
        Solution448 s = new Solution448();
        int[] nums = {1, 2, 2, 4, 5};
        System.out.println(s.findDisappearedNumbers(nums));
    }
}
