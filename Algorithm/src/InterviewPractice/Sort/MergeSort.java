package InterviewPractice.Sort;

public class MergeSort<E extends Comparable> {

    private static Comparable[] temp;

    // 1. 自顶向下的归并排序
    public void mergeSort(E[] data){
        temp = new Comparable[data.length];
        mergeSort(data, 0, data.length - 1);
    }

    private void mergeSort(E[] data, int low, int high) {
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(data, low, mid);
        mergeSort(data, mid + 1, high);
        merge(data,low,mid,high);
    }


    private void merge(E[] data, int low, int mid, int high){
        int i = low;
        int j = mid + 1;

        for(int k = low; k <= high; k++){
            temp[k] = data[k];
        }

        for(int k = low; k <= high; k++){
            if(i > mid) data[k] = (E)temp[j++];
            else if(j > high) data[k] = (E)temp[i++];
            else if(temp[i].compareTo(temp[j]) < 0){
                data[k] = (E)temp[i++];
            }else{
                data[k] = (E)temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,6,3,4,6,9,9,1};
        MergeSort solver = new MergeSort();
        solver.mergeSort(array);
        for (Integer num:array) {
            System.out.println(num);
        }
    }
}
