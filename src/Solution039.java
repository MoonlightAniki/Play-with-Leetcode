import java.util.ArrayList;
import java.util.List;

// 039. Combination Sum
// https://leetcode.com/problems/combination-sum/
public class Solution039 {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        generateCombination(candidates, target, new ArrayList<>());
        return res;
    }


    private void generateCombination(int[] nums, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (list.size() > 0 && list.get(list.size() - 1) > nums[i]) {
                continue;
            }
            list.add(nums[i]);
            generateCombination(nums, target - nums[i], list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution039 s = new Solution039();
        System.out.println(s.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
// Runtime: 12 ms, faster than 74.59% of Java online submissions for Combination Sum.
