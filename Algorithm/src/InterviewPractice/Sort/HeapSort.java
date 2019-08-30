package InterviewPractice.Sort;

import java.util.Random;

public class HeapSort<E extends Comparable> {

    public void heapSort(E[] data){
        buildHeap(data);
        for(int i = data.length - 1; i > 0; i--){
            swap(data, 0, i);
            adjust(data, 0,i - 1);
        }
    }

    private void buildHeap(Comparable[] data) {
        int n = data.length;
        int last = (n - 2) / 2;
        for(int i = last; i >= 0; i--){
            adjust(data, i, n - 1);
        }
    }
    private void adjust(Comparable[] data, int start, int end){
        int cur = start;
        int left = 2 * cur + 1;
        int right = left + 1;
        while(left <= end && right <= end){
            int temp = data[left].compareTo(data[right]) > 0 ? left : right;

            if(data[temp].compareTo(data[cur]) > 0){
                swap(data,cur,temp);
                cur = temp;
            }else{
                return;
            }
            left = 2 * cur + 1;
            right = left + 1;
        }
        if(left <= end && data[cur].compareTo(data[left]) < 0){
            swap(data, cur, left);
        }
    }


    private void swap(Comparable[] data, int i, int j){
        Comparable temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    public static void main(String[] args) {
        final int N = 30;
        Integer[] array = new Integer[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = rand.nextInt(30);
        }
        HeapSort solver = new HeapSort();
        solver.heapSort(array);
        for (Integer num:array) {
            System.out.print(num + " ");
        }
    }

}
