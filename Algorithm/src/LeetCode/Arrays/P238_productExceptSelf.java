package LeetCode.Arrays;

public class P238_productExceptSelf {

    // 1. 暴力遍历，O(N^2)超时
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = multiRes(nums,i);
        }
        return res;
    }

    private int multiRes(int[] nums, int index) {
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            if(i != index){
                res *= nums[i];
            }
        }
        return res;
    }

    // 2. 缓存左积和右积
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int total = 1;
        int[] leftPro = new int[n];
        int[] rightPro = new int[n];
        for (int i = 0; i < n; i++) {
            leftPro[i] = 1;
            rightPro[i] = 1;
        }
        for(int i = 1; i < n; i++){
            leftPro[i] = leftPro[i - 1] * nums[i - 1];
            rightPro[n - 1 - i] = rightPro[n - i] * nums[n - i];
        }

        for (int i = 0; i < n; i++) {
            res[i] = leftPro[i] * rightPro[i];
        }
        return res;
    }

}
