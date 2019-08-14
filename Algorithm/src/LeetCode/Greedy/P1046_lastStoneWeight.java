package LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *  
 *
 */
public class P1046_lastStoneWeight {

    // 1. 暴力法 ：排序，将最大的数减去次大的数，再排序，直到次大的数为 0。n^2log(n)
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        int i = stones.length - 1;
        Arrays.sort(stones);
        while(stones[i -1] != 0){
            stones[i] = stones[i] - stones[i - 1];
            stones[i - 1] = 0;
            Arrays.sort(stones);
        }
        return stones[i];
    }


    // 2. 大顶堆法：维护一个大顶堆，每次取堆顶两个数，进行操作后返回堆，直到第二堆顶元素为0；
    public int lastStoneWeight1(int[] stones) {
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < stones.length; i++){
            pQueue.add(stones[i]);
        }

        while(true){
            int first = pQueue.poll();
            int second = pQueue.poll();
            if(second == 0) return first;
            first = first - second;
            second = 0;
            pQueue.add(first);
            pQueue.add(second);
        }
    }

    public static void main(String[] args) {
        P1046_lastStoneWeight solution = new P1046_lastStoneWeight();
        int[] array = {2,7,4,1,8,1};
        System.out.println(solution.lastStoneWeight1(array));

    }
}
