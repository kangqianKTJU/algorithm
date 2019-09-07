package LeetCode.DP;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 */
public class P322_coinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for (int left = 1; left < amount + 1; left++) {
            for(int coin:coins){
                if(left - coin >= 0)
                    dp[left] = Math.min(dp[left], 1 + dp[left - coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        P322_coinChange solver = new P322_coinChange();
        System.out.println(solver.coinChange(coins, amount));
    }


}
