package LeetCode.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class P22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] path = new char[n * 2];
        int[] record = new int[2];
        backTrace(n, 0, res, path, record);
        return res;
    }

    private void backTrace(int n, int index, List<String> res, char[] path, int[] record){
        if(index == 2 * n){
            String str = new String(path);
            res.add(str);
            return;
        }
        if(record[0] < n){
            path[index] = '(';
            record[0] += 1;
            backTrace(n, index + 1, res,path, record);
            record[0] -= 1;
        }
        if(record[0] > record[1]) {
            path[index] = ')';
            record[1] += 1;
            backTrace(n, index + 1, res,path, record);
            record[1] -= 1;
        }
    }

    public static void main(String[] args) {
        P22_generateParenthesis solver = new P22_generateParenthesis();
        int n = 3;
        List<String> res = solver.generateParenthesis(n);
        for(String str:res){
            System.out.println(str);
        }
    }
}
