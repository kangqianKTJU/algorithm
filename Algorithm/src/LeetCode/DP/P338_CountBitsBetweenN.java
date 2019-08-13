package LeetCode.DP;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
 */
public class P338_CountBitsBetweenN {

    // 1. 暴力法，循环计算每个数字的含有1的个数
    public int[] countBits1(int num) {

        if(num < 0) return null;

        int[] res = new int[num + 1];
        for(int i = 0; i <= num; i++){
            res[i] = countBit(i);
        }
        return res;
    }

    private int countBit(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }


    // 2. 动态规划 + 最高有效位
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        int i = 0;
        int b = 1;

        while(b <= num){
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }

            i = 0;
            b <<= 1;
        }
        return ans;
    }


}
