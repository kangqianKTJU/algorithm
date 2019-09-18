package nowCodeAlgorithm;

public class BubbleSort {

    public static void bubblesort(int[] arr){
        if(arr == null || arr.length < 2) return;
        int n = arr.length;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
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
        bubblesort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
