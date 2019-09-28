package InterviewPractice.Sort;

public class QuickSort<E extends Comparable> {
    public void quickSort(E[] data){
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(E[] data, int low, int high){
        if(low >= high) return;
        int mid = partition(data, low, high);
        quickSort(data, low, mid - 1);
        quickSort(data, mid + 1, high);
    }

    private int partition(E[] data, int low, int high){
        E target = data[low];
        int i = low;
        int j = high;
        while(i < j){
            while(i < j && data[j].compareTo(target) >= 0){
                j--;
            }
            swap(data, i, j);
            while(i < j && data[i].compareTo(target) <= 0){
                i++;
            }
            swap(data, i, j);
        }
        return i;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,6,3,4,6,9,9,1};
        QuickSort solver = new QuickSort();
        solver.quickSort(array);
        for (Integer num:array) {
            System.out.println(num);
        }
    }
    private void swap(E[] data, int i , int j){
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
