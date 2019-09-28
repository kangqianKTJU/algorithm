package nowCodeAlgorithm;

public class NetherlandFlag {

    public static void solver(int[] nums){
        int less = -1;
        int more = nums.length - 1;
        int cur = 0;
        while(cur < more){
            if(nums[cur] == 0){
                swap(nums, cur++, ++less);
            }else if(nums[cur] == 1){
                cur++;
            }else{
                swap(nums, cur, --more);
            }
        }
    }

    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
