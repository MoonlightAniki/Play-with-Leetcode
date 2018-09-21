// 461. Hamming Distance
// https://leetcode.com/problems/hamming-distance/
public class Solution461 {

    // version 1
//    public int hammingDistance(int x, int y) {
//        int result = 0;
//        for (int i = 0; i < 32; ++i) {
//            if ((x & (1 << i)) != (y & (1 << i))) {
//                ++result;
//            }
//        }
//        return result;
//    }

    // version 2
    public int hammingDistance(int x, int y) {
        String xor = Integer.toBinaryString(x ^ y);

        int count = 0;
        for (int i = 0, len = xor.length(); i < len; ++i) {
            if (xor.charAt(i) == '1') {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(24 ^ 32));

        System.out.println(new Solution461().hammingDistance(1, 4));
        System.out.println(new Solution461().hammingDistance(24, 32));
    }
}
