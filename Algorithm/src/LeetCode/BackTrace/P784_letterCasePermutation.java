package LeetCode.BackTrace;

import sun.awt.image.ImageWatched;

import javax.sound.midi.Soundbank;
import java.util.*;

public class P784_letterCasePermutation {

    // 1. 回溯算法
    //   1. 每次判断一个字符，如果是数字，直接放入队列中，处理填充下一个字符
    //   2. 如果是字母，将该字母填入后，处理下一个填充字符，完成后，从队列中弹出字符，变大小些后再填充下一个字符。最后
    //   3. 移除字符，回溯到上一级。
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        if(len == 0) return res;
        LinkedList<Character> path = new LinkedList<>();
        dfs(S, 0, len, path, res);
        return res;
    }

    private void dfs(String S, int i, int len, LinkedList<Character> path, List<String> res){
        if (i == len) {
            StringBuilder sb = new StringBuilder();
            for (Character chi : path) {
                sb.append(chi);
            }
            res.add(sb.toString());
            return;
        }
        Character ch = S.charAt(i);
        if(! (ch >= '0' && ch <= '9')) {

            path.add(ch);
            dfs(S, i + 1, len, path, res);
            path.remove(path.size() - 1);
            path.add((char) (ch ^ (1 << 5)));
        }else{
            path.add(ch);
        }
        dfs(S, i + 1, len, path, res);
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        P784_letterCasePermutation solution = new P784_letterCasePermutation();
        String S = "a1b2";
        List<String> list = solution.letterCasePermutation(S);
        for(String str:list){
            System.out.println(str);
        }
    }
}
