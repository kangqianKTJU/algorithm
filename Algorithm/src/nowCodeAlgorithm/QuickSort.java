package nowCodeAlgorithm;

public class QuickSort {

    public static int partition(int[] nums, int low, int high){
        int leftBou = low - 1;
        for (int cur = low; cur < high; cur++) {
            if(nums[cur] <= nums[high]){
                swap(nums, ++leftBou, cur);
            }
        }
        return leftBou;
    }

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5};
        System.out.println(partition(nums, 0, nums.length - 1));
        for (int i :nums) {
            System.out.print(i + " ");
        }
    }
}
