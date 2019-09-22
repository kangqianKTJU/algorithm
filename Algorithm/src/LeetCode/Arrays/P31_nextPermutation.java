package LeetCode.Arrays;

public class P31_nextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean flag = false;

        for(int i = n - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
                flag = true;
                int maxMin = nums[i];
                int chIndex = i;
                for(int j = i; j < n; j++){
                    if(nums[j] > nums[i - 1] && nums[j] <= maxMin){
                        maxMin = nums[j];
                        chIndex = j;
                    }
                }
                swap(nums, chIndex, i - 1);
                reverse(nums, i, n - 1);
                break;
            }
        }
        if(!flag){
            int left = 0;
            int right = n - 1;
            while(left < right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }

    }

    private void reverse(int[] nums, int low, int high) {
        while(low < high){
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void sort(int[] nums, int low, int high){
        if(low >= high) return;
        int left = low - 1;
        int right = high;
        int cur = low;
        while(cur < right){
            if(nums[cur] < nums[high]){
                left++;
                cur++;
            }else{
                swap(nums, cur, --right);
            }
        }
        swap(nums,right,high);
        sort(nums, low, right - 1);
        sort(nums, right + 1, high);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,3,3};
        P31_nextPermutation solver =  new P31_nextPermutation();
        solver.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
