import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution040_V2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombination(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void generateCombination(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> solution) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(solution));
        }
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            solution.add(nums[i]);
            generateCombination(nums, target - nums[i], i + 1, res, solution);
            solution.remove(solution.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution040_V2 s = new Solution040_V2();
        System.out.println(s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
// Runtime: 28 ms, faster than 18.94% of Java online submissions for Combination Sum II.
