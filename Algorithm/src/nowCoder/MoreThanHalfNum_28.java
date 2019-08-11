package nowCoder;

import java.util.Arrays;

/**
 * 题目描述
 * P28:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_28 {

    // 1. 排序，找到中位数
    // 2. 判断，统计中位数出现次数，判断是否存在
    public int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);

        int possibleVal = array.length / 2;

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[possibleVal]) count++;
        }

        if (count > possibleVal)
            return array[possibleVal];
        else
            return 0;
    }



    // 2. 计数法
    public int MoreThanHalfNum_Solution2(int[] array) {


        int count = 1;
        int num = array[0];

        for(int i = 1; i < array.length; i++){
            if(count == 0){
                num = array[i];
                count = 1;
            }else if(num == array[i]){
                count++;
            }else{
                count--;
            }
        }

        int possibleVal = array.length / 2;

        int realCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) realCount++;
        }

        if (realCount > possibleVal)
            return array[possibleVal];
        else
            return 0;
    }



}
