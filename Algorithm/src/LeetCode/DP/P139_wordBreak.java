package LeetCode.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word:wordDict){
            set.add(word);
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        return wordBreak(chars, wordDict, n,set);
    }

    private boolean wordBreak(char[] chars, List<String> wordDict, int maxLength, Set<String> set){
        int start = 0;
        int end = 0;
        int n = chars.length;
        String temp = null;
        while(end < n){
            int savePoint = start;
            while(end < n){
                temp = new String(chars, start, end - start + 1);
                if(set.contains(temp)){
                    end++;
                    start = end;
                    break;
                }else{
                    end++;
                }
            }
            if(start == 0 && end == maxLength) return false;
                if((start == n && end == n) || wordBreak(new String(chars, start, n - start),wordDict)){
                    return true;
                }else{
                    start = savePoint;
                }
        }
        return false;
    }



    public static void main(String[] args) {
        P139_wordBreak solver= new P139_wordBreak();
        String s = "catsandog";
        List<String> words = new ArrayList<>();
        words.add("cats");
        words.add("dog");
        words.add("sand");
        words.add("and");
        words.add("cat");

        System.out.println(solver.wordBreak(s, words));

    }
}
