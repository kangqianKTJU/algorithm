package nowCodeAlgorithm;

import java.util.Random;

public class QuickSort {

    public static int partition(int[] nums, int low, int high){
        int leftBou = low - 1;
        swap(nums, high, new Random().nextInt(high - low + 1) + low);
        for (int cur = low; cur <= high; cur++) {
            if(nums[cur] <= nums[high]){
                swap(nums, ++leftBou, cur);
            }
        }
        return leftBou;
    }

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void quickSort(int[] nums){
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int low, int high){
        if(low >= high) return;
        int mid = partition(nums, low, high);
        sort(nums, low, mid - 1);
        sort(nums, mid + 1, high);
    }



    public static void main(String[] args) {
        int[] nums = {1,4242,21,36,4,5,32,123,7,1};
        quickSort(nums);
        for (int i :nums) {
            System.out.print(i + " ");
        }
    }
}
