public class HeapSort{

    public static void main(String[] args) {
        int a[] = {12, 3, 4, 45, 9, 78, 128};
        heapSort(a);
        print(a);
    }

    public static void heapSort(int array[]){
        // 建立堆
        int n = array.length;
        int startIndex = n / 2 - 1;
        for(int i = startIndex; i >= 0; --i){
            shift(array, i, n - 1);
        }

        // 取堆顶元素，调整在取堆顶元素，如此循环，直至取出所有元素
        int temp = 0;
        for(int i = n - 1; i > 0; i--){
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            shift(array, 0, i - 1);
        }

    }

    // 调整堆
    private static void shift(int array[], int low, int high){
        int parent = low;
        int maxChild = 2 * low + 1;
        int temp = array[parent];
        while (maxChild <= high){
            if(maxChild < high && array[maxChild + 1] > array[maxChild]){
                maxChild += 1;
            }
            if(temp < array[maxChild]){
                array[parent] = array[maxChild];
                parent = maxChild;
                maxChild = 2 * parent + 1;
            }else{
                break;
            }
        }
        array[parent] = temp;        
    }

    private static void print(int a[]){
        for(int i:a){
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}