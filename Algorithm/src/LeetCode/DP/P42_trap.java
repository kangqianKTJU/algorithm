package LeetCode.DP;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class P42_trap {

    // 1. 暴力法： O(N^2)
    // 除了首位俩个柱子，每个柱子上方所能拥有的水柱的高度取决于 其左右的最大高度，
    // 如果左右的最大高度有比他小的，则水是保存不住的，只有两边的最小值都比它大，才能盛住，且能盛住的
    // 水的量取决于左右两边峰值的最小值。
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;

        int max = 0;
        for(int i = 1; i < height.length - 1; i++){
            int leftMax = 0;
            int rightMax = 0;
            for(int j = 0; j < i; j++){
                if(height[j] >= leftMax) leftMax = height[j];
            }
            for(int j = i + 1; j < height.length; j++){
                if(height[j] >= rightMax) rightMax = height[j];
            }

            max += (Math.min(leftMax, rightMax) > height[i]) ? (Math.min(leftMax, rightMax) - height[i]):0;
        }
        return max;
    }



    // 2. 动态规划
    // 前面每次计算某个柱子所能容纳的水量的时候,每次都要扫描整个数组，从而使得复杂度增大，如果扫描依此记录下所有的leftMax和rightMax
    //  就能降低复杂度
    public int trap1(int[] height) {
        if(height == null || height.length <= 2) return 0;

        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        leftMax[0] = height[0];
        rightMax[length - 1] = height[length - 1];

        for(int i = 1; i < length; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for(int i = length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int max = 0;
        for(int i = 1; i < length - 2; i++){
            max += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return max;

    }

    // 3. 使用栈
    // 栈中总存放比当前栈顶元素大的一个边界，如果要判断的元素大于栈顶元素，则大小取决于这俩个边界中较小者
    public int trap2(int[] height) {
        if(height == null || height.length <= 2) return 0;

        int n = height.length;
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        int currnet = 0;
        while(currnet < n){
            while(!stack.isEmpty() && height[currnet] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int distance = currnet - stack.peek() - 1;
                max += ((Math.min(height[stack.peek()], height[currnet]) - height[top]) * distance);
            }
            stack.push(currnet++);
        }

        return max;
    }

    // 4. 双指针法

    // 每次从左右指针中找相对较小的指针，小指针旁边柱子于相对较小的指针的差就是该柱子盛下的水煮的高度。
    public int trap3(int[] height) {
        if(height == null || height.length <= 2) return 0;

        int max = 0;
        int left  = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else{
                    max += (leftMax - height[left]);
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else{
                    max += (rightMax - height[right]);
                }
                right--;
            }
        }
        return  max;
    }


    public static void main(String[] args) {
        P42_trap solution = new P42_trap();
        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap2(array));
    }
}
