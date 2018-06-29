// 771. Jewels and Stones
// https://leetcode.com/problems/jewels-and-stones/description/
class Solution771 {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        int count = 0;
        for (char ch : S.toCharArray()) {
            if (J.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution771 s = new Solution771();
        String J = "aA", S = "aAAbbbb";
        System.out.println(s.numJewelsInStones(J, S));
    }
}
