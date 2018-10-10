import java.util.Arrays;

// 338. Counting Bits
// https://leetcode.com/problems/counting-bits/
public class Solution338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            res[i] = countBit(i);
        }
        return res;
    }

    private int countBit(int num) {
        int mask = 1;
        int count = 0;
        for (int offset = 0; offset < 32; ++offset) {
            count += (num & (mask << offset)) >> offset;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution338 s = new Solution338();
        System.out.println(Arrays.toString(s.countBits(5)));
    }
}
// Runtime: 3 ms, faster than 29.46% of Java online submissions for Counting Bits.
