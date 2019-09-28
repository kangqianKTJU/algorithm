package LeetCode.Sort;

public class P215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, 0, nums.length - 1, k);
    }

    private int findK(int[] nums, int low, int high, int k){
        int temp = nums[low];
        int left = low;
        int right = high;
        while(left < right){
            while(left < right && nums[right] >= temp) right--;
            swap(nums, left, right);
            while(left < right && nums[left] < temp) left++;
            swap(nums, left, right);
        }
        if(left == (high - k + 1)){
            return nums[left];
        }else if(left < high - k + 1){
            return findK(nums, left + 1, high, k);
        }else
            return findK(nums, low, left - 1, k - (high - left + 1));
    }


    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        P215_findKthLargest solver = new P215_findKthLargest();
        System.out.println(solver.findKthLargest(arr, 2));
    }
}
