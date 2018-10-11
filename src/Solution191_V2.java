public class Solution191_V2 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution191_V2 s = new Solution191_V2();
        System.out.println(s.hammingWeight(11));
        System.out.println(s.hammingWeight(128));
    }
}
