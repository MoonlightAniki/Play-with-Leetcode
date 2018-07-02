// 495. Teemo Attacking
// https://leetcode.com/problems/teemo-attacking/description/
class Solution495 {
    // exceed time limit
//    public int findPoisonedDuration(int[] timeSeries, int duration) {
//        if (timeSeries == null || timeSeries.length == 0) {
//            return 0;
//        }
//        if (timeSeries.length == 1) {
//            return duration;
//        }
//        boolean[] marked = new boolean[timeSeries[timeSeries.length - 1] + duration];//marked[i]==true表示i被覆盖
//        for (int i = 0; i < timeSeries.length; ++i) {
//            for (int j = timeSeries[i]; j < timeSeries[i] + duration; ++j) {
//                marked[j] = true;
//            }
//        }
//        int total = 0;
//        for (int i = timeSeries[0]; i < marked.length; ++i) {
//            if (marked[i]) {
//                total++;
//            }
//        }
//        return total;
//    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        int start = timeSeries[0];
        int end = start + duration;
        int total = 0;
        for (int i = 1; i < timeSeries.length; ++i) {
            if (end < timeSeries[i]) {// 无重叠部分
                total += (end - start);
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        total += (end - start);
        return total;
    }

    public static void main(String[] args) {
        Solution495 s = new Solution495();
//        System.out.println(s.findPoisonedDuration(new int[]{1, 4}, 2));
//        System.out.println(s.findPoisonedDuration(new int[]{1, 2}, 2));
//        System.out.println(s.findPoisonedDuration(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(s.findPoisonedDuration(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
    }
}
