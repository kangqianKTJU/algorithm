package LeetCode.Hash;

import LeetCode.Common.PrintUtil;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class P350_intersect {
    // 1. 暴力查找
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            list.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++){
            if(list.contains(nums2[j])){
                res.add(nums2[j]);
                list.remove(Integer.valueOf(nums2[j]));
            }
        }
        int[] resArray = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }


    // 2. 哈希表法
    // 通过哈希表记录每个元素及其出现的次数，然后后在去里面寻找元素，找到，count--
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int j = 0; j < nums2.length; j++){
            if(map.containsKey(nums2[j])){
                Integer count = map.get(nums2[j]);
                list.add(nums2[j]);
                if(count == 1){
                    map.remove(nums2[j]);
                }else{
                    count--;
                    map.put(nums2[j],count);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }


    // 3. 双指针法： 排序+查找
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(j < nums2.length && i < nums1.length){
            if(nums2[j] == nums1[i]){
                list.add(nums2[j]);
                i++;
                j++;
            }else if(nums2[j] < nums1[i]){
                j++;
            }else{
                i++;
            }

        }
        int[] res = new int[list.size()];
        for(int k = 0; k < res.length; k++){
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        P350_intersect solution = new P350_intersect();
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};
        int[] nums1 = {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,
                13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,
                46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};

        int[] nums2 = {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,
                0,2,36,68,52,73,50,77,44,61,48};
        int[] res = solution.intersect2(nums1, nums2);
        PrintUtil.printArray(res);

    }
}
