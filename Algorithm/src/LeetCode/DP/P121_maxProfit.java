package LeetCode.DP;

import nowCoder.PrintFromTopToBottom_22;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 *
 */

public class P121_maxProfit {

    // 1. 暴力法 O(n^2)
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0 || prices.length == 1) return 0;

        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > max){
                    max = profit;
                }
            }
        }
        return max;
    }

    // 2. 贪心算法，一次遍历 O(n)

    //  从头开始遍历，如果价格下跌，那么是没有利润的，一直往谷底寻找，因为只有出现谷底次啊能进行买卖
    //  一旦出现价格上升，即出现一个谷底。不断计算到谷底的价格查，更新最大利润
    //  如果有谷底更小，则更新谷底。
    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) return 0;
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }

    // 3. 转化为最大连续子数组和
    //  两天之间的价格之差最大，对应于，这几天的价格差的和最大
    //  求出每相邻两天之间的价格差到一个新的数组，然后求出最大的连续子数组和
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int[] diff = new int[prices.length - 1];
        for(int i = 0; i <diff.length; i++){
            diff[i] = prices[i + 1] - prices[i];
        }

        int[] dp = new int[diff.length];

        dp[0] = Math.max(diff[0], 0);
        int profit = dp[0];
        for(int i = 1; i < diff.length; i++){
            dp[i] = Math.max(0, dp[i - 1] + diff[i]);
            profit = Math.max(profit, dp[i]);
        }

        return profit;
    }

    // 4. 解法3的简化
    public int maxProfit3(int[] prices) {
        int last = 0, profit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            last = Math.max(0, last + prices[i+1] - prices[i]);
            profit = Math.max(profit, last);
        }
        return profit;
    }

}
