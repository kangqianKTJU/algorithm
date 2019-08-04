package nowCoder;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci_7 {

    //1. 递归，性能不好 O(2^n)
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return Fibonacci(n-1 ) + Fibonacci(n - 2);
    }

    // 2. 迭代 O(n)
    public int Fibonacci1(int n) {
       int val1 = 0;
       int val2  = 1;
       if(n == 0) return val1;
       if(n == 1) return val2;

       for(int i = 2; i <= n; i++){
           val2 = val1 + val2;
           val1 = val2 - val1;
       }
       return val2;
    }




    public static void main(String[] args) {
        Fibonacci_7 solution = new Fibonacci_7();
        System.out.println(solution.Fibonacci(60));
    }
}
