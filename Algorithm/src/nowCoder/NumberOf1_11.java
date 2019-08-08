package nowCoder;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1_11 {

    // 1. 与 1相与， 将n右移，（负数右移的时候高位补1，右问题）
    //  1. 依次将最右位和1相与，是1的话就证明该位是1，比较后右移
    //  2. 如果是负数的话会出现死循环
    public int NumberOf1(int n) {
        int count = 0;
        while(n > 0){
            if( (n & 1) == 1){
                ++count;
            }
            n = n >> 1;
        }
        return count;

    }



    // 2. 与 1相与， 将 1左移，再与n相与
    public int NumberOf12(int n) {

        int count = 0;
        int com = 1;
        while(com != 0){
            if((com & n) != 1){
                ++count;
            }
            com = com << 1;
        }
        return count;
    }

    // 3. 利于一个数减少1后，则从第一个为1的位及其以后都取反，将其与原来的数相与则去除了该位置的1，一直到所有位置都为1
    public int NumberOf13(int n) {
        int count = 0;
        while(n != 0){
            ++count;
            n = (n & (n - 1));
        }
        return count;
    }
}
