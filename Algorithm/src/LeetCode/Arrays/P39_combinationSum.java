package LeetCode.Arrays;

import java.util.LinkedList;
import java.util.List;

public class P39_combinationSum {

    public static List<List<Integer>> res = new LinkedList<>();
    public static List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        backTrace(candidates, 0, target, 0);
        return res;
    }

    private static void backTrace(int[] nums, int lastIndex, int target, int nowSum){
        if(lastIndex >= nums.length) return;
        if(nowSum == target){
            List<Integer> temp = new LinkedList<>();
            temp.addAll(path);
            res.add(temp);
            return;
        }
        if(nowSum > target) return;
        for (int i = lastIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(nums, i, target, nowSum + nums[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        P39_combinationSum solver = new P39_combinationSum();
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> res = solver.combinationSum(nums, target);
        for(List<Integer> list:res){
            for(Integer val:list){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
