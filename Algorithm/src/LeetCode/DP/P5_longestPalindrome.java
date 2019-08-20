package LeetCode.DP;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class P5_longestPalindrome {

    // 1. 暴力判断法
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;

        char[] array = s.toCharArray();
        int[] resIndex = new int[2];
        for(int i = 0; i < s.length(); i++){
            int start = i - 1;
            int end = i + 1;

            while(start >= 0 && array[i] == array[start])start--;
            while(end < s.length() && array[i] == array[end])end++;
            int[] temp = Palindrome(array, start, end);
            if(temp[1] - temp[0] > resIndex[1] - resIndex[0])
                resIndex = temp;
        }
        return  s.substring(resIndex[0],resIndex[1]);
    }
    private int[] Palindrome(char[] array, int start, int end) {
        while(start >= 0 && end < array.length){
            if(array[start] == array[end]){
                start--;
                end++;
            }else
                break;
        }
        return new int[]{start + 1, end};
    }


    // 2. 暴力判断法，未优化
    public String longestPalindrome1(String s) {
        if(s == null || s.length() <= 1) return s;

        String maxStr = new String();
        for(int i = 0; i < s.length(); i++){
            int start = i - 1;
            int end = i + 1;

            while(start >= 0 && s.charAt(i) == s.charAt(start))start--;
            while(end < s.length() && s.charAt(i) == s.charAt(end))end++;
            String newStr = Palindrome(s, start, end);
            maxStr = newStr.length() > maxStr.length() ? newStr : maxStr;

        }
        return  maxStr;
    }
    private String Palindrome(String s, int start, int end) {
        while(start >= 0 && end < s.length()){
            if(s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }else
                break;
        }
        return s.substring(start + 1, end);
    }


    // 3. 动态规划
    //  1.长度为1的字符串本身就是回文字符串
    //  2. 长度为2的字符串只要相等就是回文字符串
    //   3. 其他长度的是其内侧是回文，且左右相等即为回文字符串，
    public String longestPalindrome2(String s) {
        if(s == null || s.length() <= 1) return s;
        int n = s.length();

        int start = 0;
        int end = 0;
        boolean dp[][] = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        for(int i = 1; i < n; i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                dp[i- 1][i] = true;
                start = i - 1;
                end = i;
            }
        }
        for(int i = 2; i < n; i++){
            for(int j = 0; j < n - i; j++){
                if(dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i)){
                    dp[j][j + i] = true;
                    if(i > end - start){
                        start = j;
                        end = j + i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);


    }

    public static void main(String[] args) {
        P5_longestPalindrome solution = new P5_longestPalindrome();
        String s = "abasadaddadasdasdavvvvv";
        System.out.println(solution.longestPalindrome2(s));
    }
}
