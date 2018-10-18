package demo;

// 01背包问题
// 有n个物品的重量和价值分别为weight和value,现在要从这些物品中取任意个物品放入容量为C的背包中，求最大的价值
public class Demo002 {

    // 使用递归

    public int knapsack(int[] weight, int[] value, int C) {
        int n = weight.length;
        return bestValue(weight, value, n - 1, C);
    }


    // 考虑将[0...index]的物品放入容量为c的空间内
    private int bestValue(int[] weight, int[] value, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        // 两种方案
        // 1. 不考虑index位置的物品
        int res = bestValue(weight, value, index - 1, c);
        // 2. 将index位置的物品放入背包中，并考虑[0...index-1]物品放入剩余空间
        if (c >= weight[index]) {
            res = Math.max(res, value[index] + bestValue(weight, value, index - 1, c - weight[index]));
        }
        return res;
    }

    public static void main(String[] args) {
        Demo002 d = new Demo002();
        int[] weight = new int[]{1, 2, 3};
        int[] value = new int[]{6, 10, 12};
        int C = 5;
        int res = d.knapsack(weight, value, C);
        System.out.println(res);
    }
}
