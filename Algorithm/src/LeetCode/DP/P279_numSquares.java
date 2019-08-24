package LeetCode.DP;

import jdk.nashorn.internal.ir.ReturnNode;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 */
public class P279_numSquares {

    // 1. 动态规划
    public int numSquares(int n) {
        int top = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        for(int i = 1; i < n; i++){
            dp[i] = i;
            for(int j = 1; i - j*j > 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}
