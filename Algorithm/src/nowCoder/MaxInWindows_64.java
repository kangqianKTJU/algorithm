package nowCoder;

import java.util.*;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows_64 {

    // 1. 使用优先队列
    //   1. 将数值依次放入一个容量为size的优先队列里
    //   2. 队列的顶部就是最大的元素，每次获取堆顶的元素
    //   3. 获取堆顶的元素后，移除加入元素的前 size - 1 个元素
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(num.length < size || size == 0){
            return res;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 0; i < size - 1; i++){
            priorityQueue.offer(num[i]);
        }

        for(int i = size - 1; i < num.length; i++){
            priorityQueue.offer(num[i]);
            res.add(priorityQueue.peek());
            priorityQueue.remove(num[i - size + 1]);
        }
        return res;
    }


    public ArrayList<Integer> maxInWindows1(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        if(num.length < size || size == 0){
            return res;
        }

        queue.add(num[0]);
        for(int i = 1; i < size - 1; i++){
            while(queue.size() > 0 && num[i] > queue.peekFirst()){
                queue.pollFirst();
            }
            queue.addLast(num[i]);
        }

        for(int i = size - 1; i < num.length; i++){
            if(queue.size() == size -1){
                if(num[i] > queue.peekFirst()){
                    while(queue.size() > 0){
                        queue.peekFirst();
                    }
                    queue.addLast(num[i]);
                }else{
                    queue.addLast(num[i]);
                }

            }else{

            }
        }

        return res;
    }



}
