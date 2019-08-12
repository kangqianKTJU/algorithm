package LeetCode.DP;

import com.sun.javafx.image.BytePixelSetter;

import javax.activation.MailcapCommandMap;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class P70_ClimbStairs {


    // 1. 动态规划
    public int climbStairs(int n) {

        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    // 2. 带记忆的递归
    public int climbStairs2(int n) {

        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        return climbStairs2C(memo, n -1) + climbStairs2C(memo, n -2);
    }

    private int climbStairs2C(int[] memo, int n) {
        if(memo[n - 1] == 0){
            memo[n - 1] = climbStairs2C(memo,n - 1) + climbStairs2C(memo,n - 2);
        }
        return memo[n - 1];
    }

    // 3. 普通递归 o(2^n) 极慢，极度不推荐使用
    public int climbStairs3(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }


    public static void main(String[] args) {
        P70_ClimbStairs solution =  new P70_ClimbStairs();
        int N = 60;

        long start = System.currentTimeMillis();
        System.out.println(solution.climbStairs2(N));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        System.out.println(solution.climbStairs(N));
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        System.out.println(solution.climbStairs3(N));
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
