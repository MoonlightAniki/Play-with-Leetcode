// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/
/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return res;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; ++i) {
            bucket.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }
        for (int i = nums.length; i >= 0; --i) {
            for (Integer integer : bucket.get(i)) {
                res.add(integer);
                if (--k == 0) {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Solution347 s = new Solution347();
        System.out.println(s.topKFrequent(nums, 2));
    }
}
// Runtime: 33 ms, faster than 35.99% of Java online submissions for Top K Frequent Elements.
