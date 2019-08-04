package nowCoder;

import java.rmi.ConnectIOException;

/**
 * Pro 6:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray_6 {

    // 1. 二分搜索法。
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0)
            return 0;

        int rightHigh = array.length - 1;

        int low = 0;
        int high = array.length - 1;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[rightHigh]){
                low = mid + 1;
            }else if(array[mid] == array[rightHigh]){
                // 特俗情况的判断 1 0 1 1 1 1
                if(array[mid] == array[low]){
                    int min = array[0];
                    for(int i = 0; i < array.length; i++){
                        min = min < array[i] ? min:array[i];
                    }
                    return min;
                }
                --rightHigh;
            }else{
                high = mid;
            }
        }
        return array[low];
    }

    // 2. 二分搜索法2 ,不跨过分界点
    public int minNumberInRotateArray2(int[] array) {
        if(array == null || array.length == 0)
            return 0;

        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while(high - low > 1){
            mid = low + (high - low) / 2;
            if(array[mid] == array[low] && array[mid] == array[high]){
                int min = array[0];
                for(int i = 0; i < array.length; i++){
                    min = min < array[i] ? min:array[i];
                }
                return min;
            }
            if(array[mid] >= array[low]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return array[high];
    }

    public static void main(String[] args) {
        MinNumberInRotateArray_6 solution = new MinNumberInRotateArray_6();
        int[] arr = new int[]{1, 0, 1, 1 ,1};
        System.out.println(solution.minNumberInRotateArray2(arr));
        System.out.println(solution.minNumberInRotateArray(arr));

    }

    //3. 暴力法：略

}
