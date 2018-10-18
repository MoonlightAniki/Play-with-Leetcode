package demo;

// 01背包问题
// 有n个物品的重量和价值分别为weight和value,现在要从这些物品中取任意个物品放入容量为C的背包中，求最大的价值
public class Demo005 {

    // 时间复杂度 O(n*C)
    // 空间复杂度 O(2*C)
    public int knapsack(int[] weight, int[] value, int C) {
        int n = weight.length;
        if (n == 0 || C <= 0) {
            return 0;
        }
        int[][] memo = new int[2][C + 1];
        for (int j = 0; j <= C; ++j) {
            if (j >= weight[0]) {
                memo[0][j] = weight[0];
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= C; ++j) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= weight[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], value[i] + memo[(i - 1) % 2][j - weight[i]]);
                }
            }
        }
        return memo[(n - 1) % 2][C];
    }

    public static void main(String[] args) {
        Demo005 d = new Demo005();
        int[] weight = new int[]{1, 2, 3};
        int[] value = new int[]{6, 10, 12};
        int C = 5;
        int res = d.knapsack(weight, value, C);
        System.out.println(res);
    }
}
