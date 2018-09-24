import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 120. Triangle
// https://leetcode.com/problems/triangle/
public class Solution120 {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        // record[i][j]表示到达 triangle[i][j] 的路径的最小和
//        List<List<Integer>> record = new ArrayList<>();
//        for (int i = 0; i < triangle.size(); ++i) {
//            if (i == 0) {
//                record.add(triangle.get(i));
//                continue;
//            }
//
//            List<Integer> temp = new ArrayList<>();
//            int leftTop = Integer.MAX_VALUE;//到达当前考察元素左上的最小和
//            int rightTop = Integer.MAX_VALUE;//达到当前考察元素右上的最小和
//            for (int j = 0; j < triangle.get(i).size(); ++j) {
//                // 第一个元素左上角没有元素
//                if (j >= 1) {
//                    leftTop = record.get(i - 1).get(j - 1);
//                }
//                // 最后一个元素右上角没有元素
//                if (j < triangle.get(i).size() - 1) {
//                    rightTop = record.get(i - 1).get(j);
//                }
//                temp.add(Math.min(leftTop, rightTop) + triangle.get(i).get(j));
//            }
//            record.add(temp);
//        }
//
//        int result = Integer.MAX_VALUE;
//        for (int i = 0, sz = record.get(record.size() - 1).size(); i < sz; ++i) {
//            int min = record.get(record.size() - 1).get(i);
//            if (result > min) {
//                result = min;
//            }
//        }
//        return result;
//    }


    // 时间复杂度 O(n^2)
    // 空间复杂度 O(n)
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int lastRowLen = triangle.get(triangle.size() - 1).size();
//        int[] resArr = new int[lastRowLen];
//        resArr[0] = triangle.get(0).get(0);
//        for (int i = 1; i < triangle.size(); ++i) {
//            for (int j = triangle.get(i).size() - 1; j >= 0; --j) {
//                if (j == triangle.get(i).size() - 1) {
//                    resArr[j] = resArr[j - 1] + triangle.get(i).get(j);
//                } else if (j == 0) {
//                    resArr[j] = resArr[j] + triangle.get(i).get(j);
//                } else {
//                    resArr[j] = Math.min(resArr[j - 1], resArr[j]) + triangle.get(i).get(j);
//                }
//            }
//        }
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < resArr.length; ++i) {
//            if (result > resArr[i]) {
//                result = resArr[i];
//            }
//        }
//        return result;
//    }


    // 时间复杂度 O(n^2)
    // 空间复杂度 O(1)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = 1; i < n; ++i) {
            triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));
            triangle.get(i).set(i, triangle.get(i).get(i) + triangle.get(i - 1).get(i - 1));
            for (int j = 1; j < i; ++j) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
            }
        }
        return Collections.min(triangle.get(n - 1));
    }


    public static void main(String[] args) {
        Solution120 s = new Solution120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(s.minimumTotal(triangle));
    }
}
