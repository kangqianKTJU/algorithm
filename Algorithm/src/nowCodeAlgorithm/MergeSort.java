package nowCodeAlgorithm;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high){
        if(low == high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low , mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[arr.length];
        int cur = low;
        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high){
            if(arr[left] < arr[right]){
                temp[cur++] = arr[left++];
            }else{
                temp[cur++] = arr[right++];
            }
        }
        if(left <= mid){
            while(left <= mid){
                temp[cur++] = arr[left++];
            }
        }else{
            while(right <= high){
                temp[cur++] = arr[right++];
            }
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }


    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {12,43,45,5,32,15,532,47};
        mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
