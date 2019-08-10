package nowCoder;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    // 1. 冒泡法
    //  从头到尾扫描，每次遇到一个基数，通过冒泡的方式把他交换到前半部分
    public void reOrderArray(int [] array) {
        for(int i = 0; i < array.length; i++){
            int j = i;
            if(array[j] % 2 == 1){
                while(j >= 1 && array[j - 1] % 2 == 0){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    j--;
                }
            }
        }
    }

    //2. 头尾指针法
    // 这个方法不适用于奇数或者偶数之间的顺序保持不变的情况,可以改造一下
    public void reOrderArray1(int [] array) {
        int head = 0;
        int tail = array.length - 1;

        while (head < tail) {
            while(array[head] % 2 == 1){
                ++head;
            }
            while(array[tail] % 2 == 0){
                --tail;
            }
            int temp = array[head];
            array[head] = array[tail];
            array[tail] = temp;
            ++head;
            ++tail;
        }
    }

    // 3. 暴力遍历法
    public void reOrderArray2(int [] array) {
        int[] res = new int[array.length];
        int index = 0;
        for(int i = 0; i < array.length; ++i){
            if(array[i] % 2 == 1){
                res[index] = array[i];
                index++;
            }
        }

        for(int i = 0; i < array.length; ++i){
            if(array[i] % 2 == 0){
                res[index] = array[i];
                index++;
            }
        }

        for(int i = 0; i < array.length; ++i){
            array[i] = res[i];
        }
    }
}
