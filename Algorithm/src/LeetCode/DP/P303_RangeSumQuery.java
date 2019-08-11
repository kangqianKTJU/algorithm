package LeetCode.DP;
/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * https://leetcode-cn.com/problems/range-sum-query-immutable/solution/ji-yi-cun-chu-dong-tai-gui-hua-bao-li-fa-dong-tai-/
 *
 */



public class P303_RangeSumQuery {

        // 1. 构造的时候计算出前每个前n项和，获取时通过角标有前 j 项和减去前 i-1 项和得到结果
        //  O(n)
        private int[] sum;
        public P303_RangeSumQuery(int[] nums) {
            sum = new int[nums.length + 1];
            for(int i = 1; i < sum.length; i++){
                // 动态规划，dp[i] = dp[i - 1] + nums[i - 1]
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }

        // 2. 暴力法：每次请求计算i，j的数之和，重新计算，O(n),略，重复计算，性能低

        // 3. 利用Map缓存，把对应的i,j 映射到 对应的和

        // 4. 利用矩阵来存储i-j的和

        // 5. 采用线段树

    }
