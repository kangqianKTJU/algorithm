package nowCodeAlgorithm;

public class HeapSort {

    public static void heapSort(int[] nums){
        buildHeap(nums,0 , nums.length - 1);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            modfiyHeap(nums, 0 , i - 1);
        }
    }

    private static void modfiyHeap(int[] nums, int start, int end) {
        int parent = start;
        int left = 2 * parent + 1;
        int temp = nums[start];
        while (left <= end){
            int maxIndex = left;
            if(left + 1 <= end && nums[left] < nums[left + 1]){
                maxIndex = left + 1;
            }
            if(temp < nums[maxIndex]){
                nums[parent] = nums[maxIndex];
            }else{
                break;
            }
            parent = maxIndex;
            left = 2 * parent + 1;
        }
        nums[parent] = temp;
    }

    public static void buildHeap(int[] nums, int start, int end){
        int parent = start;
        for (int i = start + 1; i <= end; i++) {
            parent = (i - 1) / 2;
            while(i != 0 && nums[i] > nums[parent]){
                swap(nums, i, parent);
                i = parent;
                parent = (i - 1) / 2;
            }
        }
    }

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,0,7,8,6,12,42,34,0,3,1,6};
        heapSort(nums);
        for(int val:nums){
            System.out.print(val + " ");
        }
    }

}
