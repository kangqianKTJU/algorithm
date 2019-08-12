package LeetCode.DP;

/*
P53:
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class P53_maxSubArray {


    // 1. 动态规划 O(n)
    //  dp[i] 表示以nums[i]为结尾的最大子串和
    //  dp[i -1] 若大于0 ， 则 dp[i] = dp[i - 1] + nums[i]
    //  若小于0，则dp[i] = nums[i]
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int maxSum = dp[0];
        for(int i = 1; i < nums.length; i++){
            if(dp[i - 1] > 0){
                dp[i] = dp[i -1 ] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    // 2. 在1的基础上优化一下空间
    public int maxSubArray1(int[] nums) {
        int lastMax = nums[0];
        int maxSum = lastMax;
        for(int i = 1; i < nums.length; i++){
            if(lastMax > 0)
                lastMax = lastMax + nums[i];
            else
                lastMax = nums[i];

            maxSum = Math.max(maxSum, lastMax);
        }
        return maxSum;
    }

    // 3. 分治法 O(NlogN)
    // 将数组分成两半，最大子数组要不就在左半部分，要不就在右半部分，要不就跨越中间
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return maxSubArray2(nums, 0, nums.length - 1);
    }

    private int maxSubArray2(int[] nums, int low, int high){
        if(low == high) return nums[low];
        int mid = low + (high - low) / 2;
        int sum = nums[mid];
        int max = sum;
        for(int i = mid - 1; i >= low; i--){
            sum += nums[i];
            if(sum > max) max = sum;
        }

        sum = max;
        for(int i = mid + 1; i <= high; i++){
            sum += nums[i];
            if(sum > max) max = sum;
        }

        if(low <= mid - 1){
            max = Math.max(max, maxSubArray2(nums, low, mid - 1));
        }
        if(mid + 1 <= high){
            max = Math.max(max, maxSubArray2(nums, mid + 1, high));
        }
        return max;
    }

    public static void main(String[] args) {
        P53_maxSubArray solution = new P53_maxSubArray();
        int[] array ={-2,-1};
        int res = solution.maxSubArray2(array);
        System.out.println(res);
    }
}
