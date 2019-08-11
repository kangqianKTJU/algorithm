package nowCoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetKthLeastNumbers_29 {

    //1. 利用最大堆
    //  1. 建立一个大小为k的最大堆
    //  2. 每次往里面添加数的时候，与堆顶的元素比较
    //  3. 如果大于堆顶的元素，则处理下一个元素
    //  4. 如果小于堆顶元素，则将堆顶元素弹出，将该元素放入堆中。最后就得到一个存有k个最小数的堆
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

            ArrayList<Integer> res = new ArrayList<>();
            if (input == null || input.length == 0 || input.length < k || k<= 0) return res;


            PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            for (int i = 0; i < k; i++) {
                queue.offer(input[i]);
            }

            for(int i = k ; i < input.length; i++){
                if(input[i] < queue.peek()){
                    queue.poll();
                    queue.offer(input[i]);
                }
            }

            for(int i = 0; i < k; i++){
                res.add(queue.poll());
            }

            return res;
        }


        public static void main(String[] args) {
            int[] array = {4,5,1,6,2,7,3,8};
            int k = 4;
            GetKthLeastNumbers_29 solution = new GetKthLeastNumbers_29();
            ArrayList<Integer> res = solution.GetLeastNumbers_Solution(array, k);
            for(Integer val:res){
                System.out.println(val);
            }

        }
    }

