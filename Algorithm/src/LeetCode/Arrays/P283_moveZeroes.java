package LeetCode.Arrays;

import LeetCode.Common.PrintUtil;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class P283_moveZeroes {
    public void moveZeroes(int[] nums) {

        if(nums == null || nums.length <= 1) return;

        int pZero = 0;
        int j = 0;
        while( j < nums.length){
            if(nums[pZero] != 0){
                pZero++;
                j++;
            }
            else{
                while(j < nums.length && nums[j] == 0) j++;
                if(j >= nums.length) break;
                int temp = nums[pZero];
                nums[pZero] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public void moveZeroes1(int[] nums) {

        if(nums == null || nums.length <= 1) return;

        int n = nums.length;

        int i = 0;
        for(int j = 1; j < n; j++){
            if(nums[i] != 0){
                i++;
            }else{
                if(nums[j] != 0){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                }
            }

        }
    }


    public static void main(String[] args) {
        P283_moveZeroes solution = new P283_moveZeroes();
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,0,0,0};
        int[] nums = {1,1,1,12};
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        PrintUtil.printArray(nums);
    }
}
