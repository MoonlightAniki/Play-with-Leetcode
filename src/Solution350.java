import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Map<Integer, Integer> record = new HashMap<>();
        for (int i : nums1) {
            record.put(i, record.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new LinkedList<>();
        for (int i : nums2) {
            if (record.containsKey(i)) {
                list.add(i);
                record.put(i, record.get(i) - 1);
                if (record.get(i) == 0) {
                    record.remove(i);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
