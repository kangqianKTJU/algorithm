package LeetCode.DP;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class P62_uniquePaths {
    public static int pathCount = 0;

    // 1. 回溯法
    //  1. 判断所在点是否在范围内，不在则返回
    //  2. 在的话， 看是否是最后一步，是的话加1，否则继续向下和向右寻找
    public int uniquePaths(int m, int n) {
        beAbleToArrive(m, n, 0, 0);
        int temp = pathCount;
        pathCount = 0;
        return temp;
    }

    private void beAbleToArrive(int m, int n, int i, int j) {
        if(i >= m || j >= n ) return;
        if(i == m - 1 && j == n - 1){
            pathCount++;
            return;
        }
        beAbleToArrive(m, n, i + 1, j);
        beAbleToArrive(m, n, i, j + 1);
    }

    //2. 数学法
    // 总共要走 m + n - 2 步，选取其中的 m - 1步向下走
    public int uniquePaths1(int m, int n) {
        return (int)(fact(m, m + n - 2) / fact(1, n - 1));
    }
    private double fact(int start, int end){
        double res = 1.0;
        for(int i = start; i <= end; i++){
            res *= i;
        }
        return res;
    }

    // 3. 动态规划法
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < n ; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; ++i){
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        P62_uniquePaths solution = new P62_uniquePaths();
        System.out.println(solution.uniquePaths2(23, 12));
    }

}
