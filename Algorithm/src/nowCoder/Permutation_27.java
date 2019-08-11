package nowCoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation_27 {

    // 1. 递归法
    //   1. 每次固定指定位置，然后可能的情况就是将这个位置和后面的字符进行交换，
    //   每个过程又可以递归成更小的过程，直到最后一个字符固定，就是完全确定的情况。
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0) return res;

        permutation(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }

    private void permutation(char[] chars, int fixedBit, ArrayList<String> res){
        // 终止条件：只剩最后一个字符，前面的字符都已固定

        if(fixedBit == chars.length - 1){
            String str = String.valueOf(chars);
            if(!res.contains(str)){
                res.add(str);
            }
        }else {
            // 从需要固定的位开始和后面依此交换，递归调用每次交换后，其后面的排列可能情况
            for(int j = fixedBit; j < chars.length; j++){
                swap(chars, fixedBit, j);
                permutation(chars, fixedBit + 1, res);
                swap(chars, fixedBit, j);
            }
        }
    }

    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
