package nowCodeAlgorithm;

public class GetMax {

    public static int getMax(int[] nums){
        return getMaxHelper(nums, 0, nums.length - 1);
    }
    private static int getMaxHelper(int[] nums, int low, int high){
        if(low == high) return nums[low];

        int mid = (low + high) >>> 1;
        int max1 = getMaxHelper(nums, low, mid);
        int max2 = getMaxHelper(nums, mid + 1, high);
        return max1 > max2 ? max1 : max2;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,7,2,5,34,354,24,535,3};
        System.out.println(getMax(nums));
    }
}
