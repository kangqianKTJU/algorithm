package nowCoder;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

// 1. 1个台阶，只能一次跳一个
// 2. 2个台阶， 可以一次跳2个或一次跳几个
// 3. n >= 3时
//      先跳1格，再跳 f(n - 1)格
//      先条2格，再跳 f(n - 2)格
    // 所以有 f(n - 1) + f(n - 2)格
public class JumpFloor_8 {

    // 1. 迭代法
    public int JumpFloor(int target) {
        int val1 = 1;
        int val2 = 2;
        if(target == 1){
            return val1;
        }
        if(target == 2){
            return val2;
        }
        int res = 0;;
        while(target-- > 2){
            res = val1 + val2;
            val1 = val2;
            val2 = res;
        }
        return res;
    }

    // 2. 递归法：略
}
