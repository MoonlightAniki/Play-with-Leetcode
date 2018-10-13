import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution047_V2 {
    private List<List<Integer>> res;
    private boolean[] used;


    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        generatePermutation(nums, 0, new Stack<>());
        return res;
    }

    private void generatePermutation(int[] nums, int index, Stack<Integer> stack) {
        if (index == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                    continue;
                }
                stack.push(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, stack);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution047_V2 s = new Solution047_V2();
        System.out.println(s.permuteUnique(new int[]{1, 2, 1}));
    }
}
// Runtime: 5 ms, faster than 64.88% of Java online submissions for Permutations II.