package LeetCode.DoublePoint;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 */
public class P1004_longestOnes {

    // 1. 双指针法
    // 每次遇到1尾指针加1，不满足条件时，将头指针加到跳过一个0获取一个机会改正0
    // 注意处理好跳过头指针的0，获得机会的同时，就失去了机会，所以不用操作机会次数，而且现在的长度也不变。
    public int longestOnes(int[] A, int K) {
        int max = 0;
        int count = 0;
        int strLength = A.length;
        int start = 0;
        int end = 0;

        while (end < strLength && start < strLength) {
            if (A[end] == 1) {
                count++;
            } else {
                if (K > 0) {
                    count++;
                    K--;
                } else {
                    max = Math.max(max, count);
                    while (A[start] == 1) {
                        count--;
                        start++;
                    }
                    start++;
                }
            }
            end++;
        }

        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 0, 1, 0, 1, 0, 1, 0, 1};

        int K = 2;
        P1004_longestOnes solution = new P1004_longestOnes();
        System.out.println(solution.longestOnes(array, K));

    }
}
