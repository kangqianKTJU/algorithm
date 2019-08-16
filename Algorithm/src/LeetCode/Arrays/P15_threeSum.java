package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_threeSum {

    // 1. 暴力法：O(N^4) 时间超限
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 3) return list;

        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n ; j++){
                for(int k = j + 1; k < n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        boolean reFlag = false;
                        for(List<Integer> tempList:list){
                            if(tempList.contains(nums[i]) && tempList.contains(nums[j]) && tempList.contains(nums[k])){
                                reFlag = true;
                                if(nums[i] == 0 && nums[j] == 0 && (((tempList.get(0) + tempList.get(1)) != 0) ||
                                        ((tempList.get(1) + tempList.get(2)) != 0))
                                ){
                                    reFlag = false;
                                }
                            }
                            if(reFlag){
                                break;
                            }
                        }
                        if(!reFlag){
                            List<Integer> path = new ArrayList();
                            path.add(nums[i]);
                            path.add(nums[j]);
                            path.add(nums[k]);
                            list.add(path);
                        }
                    }
                }
            }
        }
        return list;
    }



    public static void main(String[] args) {
        P15_threeSum solution = new P15_threeSum();

//        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        int[] nums = {2,-8,8,6,-14,-12,11,-10,13,14,7,3,10,-13,3,-15,7,3,-11,-8,4,5,9,11,7,1,3,13,14,-13,3,-6,-6,-12,-15,-12,-9,3,-15,-11,-6,-1,0,11,2,-12,3,-6,6,0,-6,-12,-10,-12,6,5,-4,-5,-5,-4,-11,13,5,-2,-13,-3,-7,-15,8,-15,12,-13,0,-3,6,9,-8,-6,10,5,9,-11,0,7,-15,-8,-3,-4,-6,7,7,-2,-2,-11,3,0,-6,12,0,-13,4,-3,11,-11,1,2,13,8,4,9,-1,-2,5,14,12,5,13,-6,-13,-8,9,1,5,-8,-2,-6,-1};
//        int[] nums = {-4,4,0,0,-5,0};
//        int[] nums = {0,0,0,0};


        List<List<Integer>> lists = solution.threeSum(nums);
        for(List<Integer> list:lists){
            for(Integer i:list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
