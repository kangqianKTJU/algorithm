package LeetCode.BackTrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 */
public class P401_readBinaryWatch {

    // 1. 暴力回溯
    // 直接枚举出所有排列，判断是否符合。
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        char[] time = new char[10];

        backTrace(num, 1, time,res);
        return res;
    }

    private void backTrace(int num, int i, char[] time, List<String> res){
        if(i == num + 1){
            int hourNum = 0;
            for(int k = 0; k < 4; k++){
                hourNum += time[k] * ( 1 << k) ;
            }
            if(hourNum >= 0 && hourNum <= 11){
                int minuteNum = 0;
                for(int k = 4; k < 10; k++){
                    minuteNum += time[k] * ( 1 << (k - 4)) ;
                }
                if(minuteNum < 60){
                    StringBuilder sb = new StringBuilder();
                    sb.append(hourNum);
                    sb.append(":");
                    if(minuteNum < 10){
                        sb.append("0");
                    }
                    sb.append(minuteNum);
                    String str = sb.toString();
                    if(!res.contains(str)){
                        res.add(sb.toString());
                    }
//                    String str = String.format("%d:%02d", hourNum,minuteNum);
//                    if(!res.contains(str)){
//                        res.add(str);
//                    }
                }
            }
        }
        for(int j = 0; j < time.length; j++){
            if(time[j] == 0) {
                time[j] = 1;
                backTrace(num, i + 1, time, res);
                time[j] = 0;
            }
        }
    }





    // 2. 方法一整理
    // 剔除不合理的排列
    final int[] COUNT = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
    public List<String> readBinaryWatch1(int num) {
        int[] filled  = new int[10];
        Set<String> set = new HashSet<>();
        backTrace(num, 0, set, filled);
        List<String> res = new ArrayList<String>(set);
        return res;
    }
    private void backTrace(int num, int index, Set<String> res, int[] filled){
        if(index > num){
            String str = calTime(filled);
            res.add(str);
            return;
        }
        for(int i = index; i < filled.length; i++){
            if(filled[i] == 0){
                filled[i] = 1;
                if(sum(filled, 0, 3) < 12 && sum(filled, 4, 9) < 60){
                    backTrace(num, index + 1, res, filled);
                }
                filled[i] = 0;
            }
        }
    }
    private String calTime(int[] filled){
        int hour = sum(filled, 0, 3);
        int minute = sum(filled, 4, 9);
        StringBuilder sb = new StringBuilder();
        sb.append(hour);
        sb.append(":");
        if(minute <= 9){
            sb.append("0");
        }
        sb.append(minute);
        return sb.toString();
    }
    private int sum(int[] filled, int i, int j){
        int sum = 0;
        for(int k = i; k <= j; k++){
            sum += COUNT[k] * filled[k];
        }
        return sum;
    }





    // 2. 遍历所有的时间组合，看是否含有指定数目的1

    public static void main(String[] args) {
        P401_readBinaryWatch solution = new P401_readBinaryWatch();
        List<String> list = solution.readBinaryWatch1(2);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
