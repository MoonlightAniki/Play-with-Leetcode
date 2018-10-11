public class Solution191_V3 {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution191_V3 s = new Solution191_V3();
        System.out.println(s.hammingWeight(11));
        System.out.println(s.hammingWeight(128));
    }
}
// Runtime: 2 ms, faster than 13.72% of Java online submissions for Number of 1 Bits.
