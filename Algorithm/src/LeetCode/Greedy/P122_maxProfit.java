package LeetCode.Greedy;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class P122_maxProfit {
    public int maxProfit(int[] prices) {

        // 1.贪心算法
        if (prices == null || prices.length <= 1) return 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
            } else {
                // 找到一个最高点卖出去
                while (i + 1 <= prices.length - 1 && prices[i + 1] >= prices[i]) {
                    i++;
                }
                maxProfit += (prices[i] - minPrice);
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    //2. 插值法；
    // 只要某一天的价格比前天的价格高，就可以认为可以前天买入，今天卖出，因为没有买卖次数限制，相当于求出所有
    // 相邻差为正数的和。


    public static void main(String[] args) {
        P122_maxProfit solution = new P122_maxProfit();

//        int[] nums = {7,6,4,3,1};
//        int[] nums = {};
//        int[] nums = {1};
//        int[] nums = {1,3};
//        int[] nums = {4,3};
        int[] nums = {5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0};
        System.out.println(solution.maxProfit(nums));
    }


}
