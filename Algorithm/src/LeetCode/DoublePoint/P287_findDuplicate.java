package LeetCode.DoublePoint;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假 * 设只有一个重复的整数，找出这个重复的数。
 *
 *说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 */
public class P287_findDuplicate {
    // 1. 暴力O(N^2)
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == nums[i])
                    return nums[j];
            }
        }
        return -1;
    }

    // 2. 二分区间法
    //
    public int findDuplicate1(int[] nums){
        return findDuplicate1Rc(nums, 1, nums.length - 1);
    }

    public int findDuplicate1Rc(int[] nums, int low, int high){
        int small = 0;
        int greater = 0;
        int midC = 0;
        int mid = low + (high - low) / 2;
        int n = nums.length;
        if((high - low + 1) % 2 == 0){
            for(int i = 0; i < n; i++){
                if(nums[i] <= mid && nums[i] >= low) small++;
                else if(nums[i] > mid && nums[i] <= high) greater++;
            }
            if(small >= 2 && greater <= 1 && (mid == low )) return low;
            if(greater >= 2 && small <= 1 && (high - mid == 1)) return high;
            if(small > greater){
                return findDuplicate1Rc(nums, low, mid);
            }else{
                return findDuplicate1Rc(nums, mid + 1, high);
            }
        }else{
            for(int i = 0; i < n; i++){
                if(nums[i] < mid && nums[i] >= low) small++;
                else if(nums[i] == mid) midC++;
                else if(nums[i] > mid && nums[i] <= high) greater++;
            }
            if(midC > 1) return mid;
            if(small >= 2 && greater <= 1 && (mid - low) == 1) return low;
            if(greater >= 2 && small <= 1 && (high -mid) == 1) return high;

            if(small > greater){
                return findDuplicate1Rc(nums, low, mid - 1);
            }else{
                return findDuplicate1Rc(nums, mid + 1, high);
            }
        }
    }

    // 3. 弗洛伊德的乌龟和兔子（循环检测）
    public int findDuplicate2(int[] nums){
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        slow = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if(slow == fast) return slow;
        }
    }

    // 4. 二分法
    public int findDuplicate3(int[] nums){
        int len = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int small = 0;
            int mid = low + (high - low) / 2;
            for(int i = 0; i < len; i++){
                if(nums[i] <= mid){
                    small++;
                }
            }
            if(small > mid){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        P287_findDuplicate solver = new P287_findDuplicate();
        int[] nums = new int[]{1,3,4,4,2};
        System.out.println(solver.findDuplicate3(nums));
    }
}
