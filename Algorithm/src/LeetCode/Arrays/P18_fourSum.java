package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) return res;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 3; i++){
            if(nums[i] > target && nums[i] >= 0) return res;
            if(i >= 1 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; j++){
                if(nums[i] + nums[j] > target && nums[j] >= 0) break;
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;

                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                    }
                    if(sum < target) left++;
                    else if(sum > target)right--;
                    else{
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,2,-5,0,-1,4};
        int target = 3;
        P18_fourSum solver = new P18_fourSum();
        solver.fourSum(arr, target);
    }
}
