import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/description/
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> record = new HashSet<>();
        for (int i : nums1) {
            record.add(i);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums2) {
            if (record.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] res = new int[resultSet.size()];
        Iterator<Integer> it = resultSet.iterator();
        for (int i = 0; i < res.length; ++i) {
            res[i] = it.next();
        }
        return res;
    }
}
