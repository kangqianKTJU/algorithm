package nowCoder;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
 */
public class RectCover_10 {
    public int RectCover(int target) {
        int val1 = 1;
        int val2 = 2;
        if(target == 0) return 0;
        if(target == 1) return val1;
        if(target == 2) return val2;

        while(target-- > 2){
            val2 = val1 + val2;
            val1 = val2 - val1;
        }
        return val2;
    }
}
