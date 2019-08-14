package LeetCode.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class P401_readBinaryWatch {
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
//                    String str = String.format("%d:%02d",hourNum,minuteNum);
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


    // 2. 遍历所有的时间组合，看是否含有指定数目的1

    public static void main(String[] args) {
        P401_readBinaryWatch solution = new P401_readBinaryWatch();
        List<String> list = solution.readBinaryWatch(2);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
