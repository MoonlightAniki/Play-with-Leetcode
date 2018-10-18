package demo;

// 01背包问题
// 有n个物品的重量和价值分别为weight和value,现在要从这些物品中取任意个物品放入容量为C的背包中，求最大的价值
public class Demo006 {

    // 时间复杂度 O(n*C)
    // 空间复杂度 O(C)
    public int knapsack(int[] weight, int[] value, int C) {
        int n = weight.length;
        if (n == 0 || C <= 0) {
            return 0;
        }
        int[] memo = new int[C + 1];
        for (int j = C; j >= weight[0]; --j) {
            memo[j] = weight[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = C; j >= weight[i]; --j) {
                memo[j] = Math.max(memo[j], value[i] + memo[j - weight[i]]);
            }
        }
        return memo[C];
    }

    public static void main(String[] args) {
        Demo006 d = new Demo006();
        int[] weight = new int[]{1, 2, 3};
        int[] value = new int[]{6, 10, 12};
        int C = 5;
        int res = d.knapsack(weight, value, C);
        System.out.println(res);
    }
}
