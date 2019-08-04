package nowCoder;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

/**
 * 有数学归纳法知道，有2^(n-1)种跳法
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1);
 * f(n) = 2 * f(n - 1)
 */
public class JumpFloorII_9 {

    // 1. 数学公式
    public int JumpFloorII(int target) {
        return 1 << --target;
    }

    // 2. 递推
    public int JumpFloorII1(int target) {
        if(target == 1) return 1;
        int res = 1;
        while(target-- >= 2){
            res *= 2;
        }
        return res;
    }
}
