package demo;

// 01背包问题
// 有n个物品的重量和价值分别为weight和value,现在要从这些物品中取任意个物品放入容量为C的背包中，求最大的价值
public class Demo003 {

    // 使用记忆化搜索+递归

    private int[][] memo;

    public int knapsack(int[] weight, int[] value, int C) {
        int n = weight.length;
        memo = new int[n][C + 1];//memo[i][j]表示将[0...i]范围内的物品放入容量为j的空间的最大价值
        return bestValue(weight, value, n - 1, C);
    }

    private int bestValue(int[] weight, int[] value, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != 0) {
            return memo[index][c];
        }
        int res = bestValue(weight, value, index - 1, c);//不考虑index位置的物品
        if (c >= weight[index]) {
            res = Math.max(res, value[index] + bestValue(weight, value, index - 1, c - weight[index]));
        }
        memo[index][c] = res;
        return res;

    }

    public static void main(String[] args) {
        Demo003 d = new Demo003();
        int[] weight = new int[]{1, 2, 3};
        int[] value = new int[]{6, 10, 12};
        int C = 5;
        int res = d.knapsack(weight, value, C);
        System.out.println(res);
    }
}
