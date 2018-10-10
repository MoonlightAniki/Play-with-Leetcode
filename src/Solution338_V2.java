import java.util.Arrays;

public class Solution338_V2 {

    // 动态规划
    // 这个问题可以从另一个问题类推：
    // 一个非负数各位数字中有多少个1？
    // 解决方案：memo[i] = memo[i / 10] + (i % 10 == 1) ? 1 : 0;
    // 求解 memo[i] 时 memo[i/10] 的已经求解出来了
    public int[] countBits(int num) {
        int memo[] = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
//            memo[i] = memo[i / 2] + (i % 2);
            memo[i] = memo[i >> 1] + i % 2;
        }
        return memo;
    }

    public static void main(String[] args) {
        Solution338_V2 s = new Solution338_V2();
        System.out.println(Arrays.toString(s.countBits(5)));

        System.out.println(countOnes(Integer.parseInt("10101", 16), 16));
        System.out.println(countOnes(1771056, 10));
    }

    // 将num转成radix进制后各位数字中1的个数
    private static int countOnes(int num, int radix) {
        int[] memo = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            memo[i] = memo[i / radix] + ((i % radix == 1) ? 1 : 0);
        }
        return memo[num];
    }
}
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Counting Bits.
