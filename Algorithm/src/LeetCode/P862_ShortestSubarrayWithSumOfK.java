package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * P 862：
 * <p>
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * <p>
 * If there is no non-empty subarray with sum at least K, return -1.
 * <p>
 * 问题描述：
 * 和不小于K的最短子序列
 */
public class P862_ShortestSubarrayWithSumOfK {

    // 1. 左右指标法 O(N^3) 虽然比暴力法要算的少，但是还是同一级别的，效率太低。

    //  1. 使用右指标right表示以其为结尾的最短序列
    //  2. 从right开始向left累加，过得到满足的条件。记录下来
    //  3. right++ , right++ 的累加和位数不能超过left，
    public int shortestSubarray(int[] A, int K) {

        int left = 0;
        int right = 0;
        int min = A.length + 1;
        while (right < A.length) {

            // 从right累加到 right - 1, right - 2, right - 3, ... , left. 有满足条件姐结束。
            for (int i = right; i >= left; i--) {
                int sum = 0;
                for (int j = right; j >= i; j--) {
                    sum += A[j];
                }
                if (sum >= K && (right - i + 1) < min) {
                    min = right - i + 1;
                    left = i;
                    break;
                }
            }
            right++;
        }

        return min > A.length ? -1 : min;
    }


    // 2. 左右指标改进法，前面每次判断和是否满足时，否要重复计算，可以考虑前i向和存起来 O(n^2)
    public int shortestSubarray1(int[] A, int K) {

        int[] sumOfN = new int[A.length + 1];

        for (int i = 1; i < sumOfN.length; i++) {
            sumOfN[i] = sumOfN[i - 1] + A[i - 1];
        }

        int left = 0;
        int right = 0;
        int min = A.length + 1;
        while (right < A.length) {
            // 从right累加到 right - 1, right - 2, right - 3, ... , left. 有满足条件姐结束。
            for (int i = right; i >= left; i--) {
                if (sumOfN[right + 1] - sumOfN[i] >= K && (right - i + 1) < min) {
                    min = right - i + 1;
                    left = i;
                    break;
                }

            }
            right++;
        }
        return min > A.length ? -1 : min;
    }



    // 3. 队列法
    //  使用队列储存要遍历的信息
    public int shortestSubarray2(int[] A, int K) {
        int N = A.length;

        int[] Sum = new int[N + 1];
        for(int i = 1; i < Sum.length; i++){
            Sum[i] = Sum[i - 1] + A[i -1];
        }

        int min = N + 1;

        Deque<Integer> queue = new LinkedList<Integer>();

        for(int y = 0; y < N + 1; y++){
            while(!queue.isEmpty() && Sum[y] <= Sum[queue.getLast()]){
                queue.pollLast();
            }
            while(!queue.isEmpty() && Sum[y] - Sum[queue.getFirst()] >= K){
                min = Math.min(min, y - queue.removeFirst());
            }

            queue.addLast(y);
        }

        return min > N ? -1 : min;
    }


        private static boolean slideWindow(int[] A, int size) {
        if (A == null || A.length == 0 || A.length < size || size <= 0) return false;

        return false;
    }

    public static void main(String[] args) {
        P862_ShortestSubarrayWithSumOfK solution = new P862_ShortestSubarrayWithSumOfK();
        int A[] = {12,313,131,312,312,-323,232};
        int k = 5006414;

        System.out.println(solution.shortestSubarray1(A, k));
    }
}
