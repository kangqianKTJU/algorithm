package LeetCode.Arrays;

import LeetCode.Common.PrintUtil;
import sun.security.util.Length;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class P26_removeDuplicates {

    // 1. 暴力挪动法
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        if(n == 1) return 1;

        int i = 0;
        int count = 1;
        while(count < n){
            if(nums[i] != nums[i + 1]){
                i++;
            }else{
                for(int j = i; j < n - 1; j++){
                    nums[j] = nums[j + 1];
                }
            }
            count++;
        }

        return i + 1;
    }

    // 2. 使用额外空间
    public int removeDuplicates1(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        if(n == 1) return 1;

        int i = 0;
        int j = 0;
        int[] temp = new int[n];
        while(i < n - 1){
            if(nums[i] != nums[i + 1]){
                temp[j++] = nums[i];
                i++;
            }else{
                temp[j++] = nums[i];
                i += 2;
            }
        }
        if(i == n - 1){temp[j++] = nums[i];}

        for(int k = 0; k < j; k++){
            nums[k] = temp[k];
        }
        return j;
    }


    // 3. 双指针法：
    // 用一个慢指针指向正要操作的元素， 快指针指向后方，
    // 如果快慢指针指向的元素不一样 慢指针前进，如果一样，快指针前进，直到找到不同的元素，
    public int removeDuplicates2(int[] nums) {

        int n = nums.length;

        int i = 0;
        for(int j = 1; j < n; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        P26_removeDuplicates solution = new P26_removeDuplicates();
        int[] nums = {1,2,3};
        int length = solution.removeDuplicates1(nums);
        System.out.println(length);
        for(int i = 0; i < length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
