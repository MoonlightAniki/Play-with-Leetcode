package demo;

public class Demo001 {

    // 记忆化搜索
//    private int[] memo;
//    private int count;
//    public int fib(int n) {
//        ++count;
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        if (memo[n] == -1) {
//            memo[n] = fib(n - 1) + fib(n - 2);
//        }
//        return memo[n];
//    }


    // 动态规划
    public int fib(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; ++i) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Demo001 d = new Demo001();
        int n = 1000;
        long startTime = System.nanoTime();
        int result = d.fib(n);
        double time = (System.nanoTime() - startTime) / 1000000000.0;
        System.out.println(String.format("fib(%d):%d", n, result));
        System.out.println("time:" + time + "s.");
    }
}
