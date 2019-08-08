package nowCoder;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import sun.reflect.generics.scope.DummyScope;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Pro 50: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate_50 {
    // 1.暴力解法 O(n2)
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(numbers[i] == numbers[j]) {
                    duplication[0] = numbers[j];return true;
                }
            }
        }
        return false;
    }

    // 2. 排序+ 查找 O(NlogN + N)
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers == null || length == 1) return false;
        Arrays.sort(numbers);
        for(int i = 1; i < length; i++){
            if(numbers[i] == numbers[i - 1]){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    // 3. hash表 O(N)
    public boolean duplicate3(int numbers[],int length,int [] duplication) {
        HashMap<Integer,Object> map = new HashMap<>();

        for(int i = 0; i < length; i++){
            if(map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }else{
                map.put(numbers[i],-1);
            }
        }
        return false;
    }


    // 4. 利用索引和数值的关系 O(N)
    public boolean duplicate4(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 1) return false;
        for(int i = 0; i < length; i++){
            while(numbers[i] != i){
                int temp = numbers[i];

                if(temp == numbers[temp]){
                    duplication[0] = temp;
                    return true;
                }
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    // 5. 位运算的散列
    public boolean duplicate5(int numbers[],int length,int [] duplication) {
        // ToDo
        return false;
    }




}
