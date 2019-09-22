package LeetCode.Arrays;

import javafx.util.Pair;

import java.util.LinkedList;

public class P209_minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int n = nums.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++ ){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int minLen = Integer.MAX_VALUE;
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<Integer, Integer>(0,sum[0]));
        int i = 1;
        while(i <= n){
            if(queue.isEmpty()) break;
            Pair<Integer, Integer> top = queue.peekFirst();

            if(sum[i] - top.getValue() >= s && (i - top.getKey()) < minLen){
                minLen = i - top.getKey();
                queue.pollFirst();
                queue.addLast(new Pair<Integer, Integer>(i,sum[i]));
            }else if(i - top.getKey() < minLen){
                queue.addLast(new Pair<Integer, Integer>(i,sum[i]));
                i++;
            }else{
                queue.pollFirst();
            }
        }
        return minLen;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int n = nums.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++ ){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 1;
        while(right <= n){
            if(sum[right] - sum[left] >= s && right - left < minLen){
                minLen = right - left;
                left++;
            }else if(right - left < minLen) right++;
            else left++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,4};
        int target = 4;

        P209_minSubArrayLen solver = new P209_minSubArrayLen();
        System.out.println(solver.minSubArrayLen(target, arr));

    }

}
