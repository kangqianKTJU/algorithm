package LeetCode.DP;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode/
 */
public class P198_rob {

    // 1.动态规划， 使用记录数组
    public int rob(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length == 1) return dp[0];

        dp[1] = Math.max(nums[0], nums[1]);
        if(nums.length == 2) return dp[1];

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
        "kkq".to
    }


    // 2. 动态规划， 使用记录变量
    public int rob1(int[] nums) {
        int prevMax = 0;
        int nowMax = 0;
        if(nums == null) return prevMax;

        for(int i = 0; i < nums.length; i++){
            int temp = nowMax;
            nowMax = Math.max(prevMax + nums[i], nowMax);
            prevMax = temp;
        }
        return nowMax;
    }
}
