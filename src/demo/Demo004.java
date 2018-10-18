package demo;

// 01背包问题
// 有n个物品的重量和价值分别为weight和value,现在要从这些物品中取任意个物品放入容量为C的背包中，求最大的价值
public class Demo004 {

    // 动态规划
    // 时间复杂度 O(n*C)
    // 空间复杂度 O(n*C)
    public int knapsack(int[] weight, int[] value, int C) {
        int n = weight.length;
        if (n == 0 || C <= 0) {
            return 0;
        }
        int[][] memo = new int[n][C + 1];//memo[i][j]表示将[0...i]范围内的物品放入容量为j的空间内的最大价值,memo[n-1][C]就是问题的解
        //初始化只放入第一个物品的情况
        for (int j = 0; j <= C; ++j) {//遍历列所以使用j
            if (j >= weight[0]) {
                memo[0][j] = weight[0];
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= C; ++j) {
                memo[i][j] = memo[i - 1][j];//不将i位置的物品放入背包中
                if (j >= weight[i]) {
                    memo[i][j] = Math.max(
                            memo[i][j],
                            value[i] + memo[i - 1][j - weight[i]]//将i位置的物品放入，并考虑将[0...i-1]范围内物品放入j-weight[i]容量的空间
                    );
                }
            }
        }
        return memo[n - 1][C];
    }

    public static void main(String[] args) {
        Demo004 d = new Demo004();
        int[] weight = new int[]{1, 2, 3};
        int[] value = new int[]{6, 10, 12};
        int C = 5;
        int res = d.knapsack(weight, value, C);
        System.out.println(res);
    }
}
