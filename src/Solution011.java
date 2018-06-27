// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/description/
public class Solution011 {

    // Status: Time Limit Exceeded
    // 时间复杂度 O(n2)
//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        int len = height.length;
//        for (int r = len - 1; r > 0; --r) {
//            for (int l = 0; l < r; ++l) {
//                int area = calculateArea(height, l, r);
//                if (maxArea < area) {
//                    maxArea = area;
//                }
//            }
//        }
//        return maxArea;
//    }

    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxArea = 0;
        int area = 0;
        while (left < right) {
            area = calculateArea(height, left, right);
            if (area > maxArea) {
                maxArea = area;
            }
            // 由于面积是由较短的边决定的，所以需要增大短边的长度
//            if (height[left] < height[right]) {
//                ++left;
//            } else {
//                --right;
//            }
            //上面的代码可进一步优化，减少多余的面积计算，实际上这个优化反而让时间效率降低了...
            if (height[left] < height[right]) {
                do {
                    ++left;
                } while (left < right && height[left - 1] >= height[left]/*当前的高度比上一个索引的高度还小，需要继续增大left找到一个比原来高度要高的索引*/);
            } else {
                do {
                    --right;
                } while (left < right && height[right + 1] >= height[right]);
            }
        }
        return maxArea;
    }

    private int calculateArea(int[] arr, int l, int r) {
        return (r - l) * Math.min(arr[l], arr[r]);
    }

    public static void main(String[] args) {
        Solution011 s = new Solution011();
        int[] height = {1, 3, 2, 5, 25, 24, 5};

        System.out.println(s.maxArea(height));
    }
}
