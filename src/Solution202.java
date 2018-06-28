import java.util.HashSet;
import java.util.Set;

// 202. Happy Number
// https://leetcode.com/problems/happy-number/description/
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (true) {
            n = calcSum(n);
            if (n == 1) {
                return true;
            }
            if (record.contains(n)) {
                return false;
            } else {
                record.add(n);
            }
        }
    }

    private int calcSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution202 s = new Solution202();
        System.out.println(s.calcSum(19));

        System.out.println(s.isHappy(19));
    }
}
