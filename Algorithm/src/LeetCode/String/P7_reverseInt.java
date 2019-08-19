package LeetCode.String;

import jdk.nashorn.internal.ir.LiteralNode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class P7_reverseInt {
    public int reverse(int x) {
        int n = Math.abs(x);
        List<Integer> bitList = new ArrayList<>();
        while(n != 0){
            bitList.add(n % 10);
            n /= 10;
        }
        int sum = 0;
        for(int i = 0; i < bitList.size(); i++){
            int before = sum;
            sum *= 10;
            sum += bitList.get(i);
            if(sum / 10 != before){
                return 0;
            }
        }

        return x > 0 ? sum : -sum;
    }

    public static void main(String[] args) {
        P7_reverseInt solution = new P7_reverseInt();
        System.out.println(solution.reverse(2022222228));
    }
}
