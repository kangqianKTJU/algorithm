package LeetCode.String;

import com.sun.javaws.Main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class P387_firstUniqChar {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;

        Map<Character, Integer> map = new LinkedHashMap();

        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }


        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(1 == map.get(ch)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P387_firstUniqChar solution = new P387_firstUniqChar();

//        String s = "leetcode";
//        String s = "loveleetcode";
//        String s = "";
//        String s = "c";
        String s = "cc";
        System.out.println(solution.firstUniqChar(s));
    }
}
