package LeetCode.BackTrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class P78_subsets {

    // 1. 回溯
    //  1. 传入index,若 index 所在的元素不包含在path中，把path传递继续处理下一个元素
    //  2. 若存在，存入path中，继续处理下一个元素
    //  3. 存在都不存在的情况都考虑完了，从path移除，回溯上一级。
   public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        subsets(nums, 0, res, path);
        return res;
    }
    private void subsets(int[] nums, int index, List<List<Integer>> res, ArrayList<Integer> path){
        if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        subsets(nums, index + 1, res, path);
        path.add(nums[index]);
        subsets(nums, index + 1, res, path);
        path.remove(path.size() - 1);
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
