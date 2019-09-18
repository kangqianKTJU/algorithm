package nowCodeAlgorithm;

public class InsertSort {

    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--){
                if(arr[j - 1] > arr[j]){
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {12,43,45,5,32,532,47};
        insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
