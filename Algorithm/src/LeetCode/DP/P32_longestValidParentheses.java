package LeetCode.DP;

import java.util.LinkedList;

public class P32_longestValidParentheses {
    public int longestValidParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int n = s.length();
        int length = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            Character ch = s.charAt(i);
            if(!stack.isEmpty() && ch == ')'){
                Character ch1 = stack.peek();
                if(ch1 == '('){
                    stack.pop();
                    length += 2;
                }else{
                    stack.push(ch);
                    max = Math.max(max,length);
                    length = 0;
                }
            }else{
                stack.push(ch);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P32_longestValidParentheses solver = new P32_longestValidParentheses();
        String s = ")()())()";
        System.out.println(solver.longestValidParentheses(s));
    }
}
