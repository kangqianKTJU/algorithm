package LeetCode.BackTrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backTrace(nums, 0, res, path, visited);
        return res;
    }

    private void backTrace(int[] nums, int index, List<List<Integer>> res,
                           List<Integer> path, boolean[] visited)
    {
           if(index == nums.length){
               List<Integer> temp = new ArrayList<>(path);
               res.add(temp);
           }

           for(int i = 0; i < visited.length; i++){
               if(!visited[i]){
                   visited[i] = true;
                   path.add(nums[i]);
                   backTrace(nums, index + 1, res, path, visited);
                   path.remove(path.size() - 1);
                   visited[i] = false;
               }
           }
    }

    public static void main(String[] args) {
        P46_permute solver = new P46_permute();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = solver.permute(nums);
        for(List<Integer> list : res){
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
