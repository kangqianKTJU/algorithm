package LeetCode.SlidingWindow;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P3_lengthOfLongestSubstring {

    // 1. hash表，
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] array = s.toCharArray();

        int max = 1;
        int start = 0;
        while(start < array.length){
            int[] res = lengthOfLongestSubstringHelper(array,start);
            max = Math.max(max, res[1]);
            start = res[0] + 1;
        }
        return max;
    }

    // 记录上一次重复的字符的索引，以及以start开头的字符的最长不重复字串的长度。
    private int[] lengthOfLongestSubstringHelper(char[] array, int start){
        int[] res = new int[2];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = start; i < array.length; i++){
            if(map.containsKey(array[i])){
                res[0] = map.get(array[i]);
                res[1] = i - start;
                return res;
            }else {
                map.put(array[i], i);
            }
        }
        res[0] = array.length;
        res[1] = array.length - start;
        return res;
    }


    // 2. 滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] array = s.toCharArray();
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        LinkedList<Character> queue = new LinkedList<>();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                max = Math.max(max, queue.size());
                while(!queue.peek().equals(array[i])){
                    Character ch = queue.pollFirst();
                    map.remove(ch);
                }
                Character ch = queue.pollFirst();
                map.remove(ch);
            }
            queue.addLast(array[i]);
            map.put(array[i], i);
        }
        max = Math.max(max, queue.size());
        return max;
    }

    public static void main(String[] args) {
        P3_lengthOfLongestSubstring solution = new P3_lengthOfLongestSubstring();
        String str = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring1(str));
    }
}
