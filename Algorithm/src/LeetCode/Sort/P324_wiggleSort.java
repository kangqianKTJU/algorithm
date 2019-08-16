package LeetCode.Sort;

import LeetCode.Common.PrintUtil;

import java.util.Arrays;

/**
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 */
public class P324_wiggleSort {
    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int mid = (n - 1) / 2;
        int[] temp = new int[n];

        for(int i = 0; i < n ; i++){
            if(i % 2 == 0){
                temp[i] = nums[i / 2];
            }else{
                temp[i] = nums[mid + 1 + i / 2 ];
            }
        }
        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        P324_wiggleSort solution = new P324_wiggleSort();
        int[] nums = {1, 5, 1, 1, 6, 4, 2};
        solution.wiggleSort(nums);
        PrintUtil.printArray(nums);

    }

}
