package nowCoder;

import sun.security.util.Length;

import java.util.Random;
import java.util.logging.Level;

/**
 * 题目描述
 * P30:
 *      HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray_30 {


    // 1. 循环 + 递归法 O(n^2)
    // 问题： 消耗大量的栈，可能造成栈的溢出。

    //    1. 遍历以每一位置开头的字符串的最大连续子序列
    //    2. 以 i 位置为开头的字符串的最大子序列为 max(array[i], array[i] + [i+1开头的字符串的最大子序列] )
    //    3. 遍历得到最大字串

    public int FindGreatestSumOfSubArray(int[] array) {

        if(array == null || array.length == 0) return 0;

        int max = array[0];
        for(int i = 0; i < array.length; i++){
            int res = greastSumWithStart(array, i);
            if( res > max){
                max = res;
            }
        }
        return max;
    }

    private int greastSumWithStart(int[] array, int start){
        if(start == array.length - 1){
            return array[start];
        }
        return Math.max(array[start], array[start] + greastSumWithStart(array, start + 1));
    }


    // 2. 暴力法，简单直接，效率很低O(n^3)
    public int FindGreatestSumOfSubArray1(int[] array) {
        int max = array[0];

        for(int i =0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                int sum = 0;
                for(int k = i ; k <= j; k++){
                    sum += array[k];
                }
                if(sum > max){
                    max = sum;
                }
            }
        }

        return max;
    }


    // 3. 改进方法1 O(n)
    // 方法一中，从前往后，计算0开始的字符串的最大子序列要计算1，2，3...开始的子序列
    //   计算1开头的子序列要计算2，3，4...开头的子序列，造成重复的计算
    //
    //  1. 从后往前计算， 每次计算的结果都保存起来
    //   2. 下一次计算的时候，不用重复计算，直接使用上一次计算的结果
    //


    public int FindGreatestSumOfSubArray2(int[] array) {

        if(array == null || array.length == 0) return 0;

        int max = array[array.length - 1];
        int lastMax = max;

        for(int i = array.length - 2; i >=0; i--){
            lastMax = Math.max(array[i], array[i] + lastMax);
            if(lastMax > max){
                max = lastMax;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        FindGreatestSumOfSubArray_30 solution = new FindGreatestSumOfSubArray_30();

        int N = 50000;
        Random random = new Random(1000);
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();
//        System.out.println(solution.FindGreatestSumOfSubArray(array));
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        start = System.currentTimeMillis();
        System.out.println(solution.FindGreatestSumOfSubArray1(array));
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        System.out.println(solution.FindGreatestSumOfSubArray2(array));
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
