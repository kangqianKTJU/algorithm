package LeetCode.BackTrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class P78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, nums.length - 1, res);
        return res;
    }
    private List<List<Integer>> subsets(int[] nums, int end, List<List<Integer>> res){
        List<Integer> path = new ArrayList<Integer>();
        if(end == -1) {
            res.add(path);
            return res;
        }
        res = subsets(nums, end - 1, res);
        List<List<Integer>> copy = new ArrayList<>();
        for(List<Integer> list:res){
            list.add(nums[end]);
        }
        res.addAll(copy);
        res.add(path);
        return res;
    }

    public static void main(String[] args) {
        P78_subsets solver = new P78_subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solver.subsets(nums);
        for(List<Integer> list:res){
            for(Integer i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
