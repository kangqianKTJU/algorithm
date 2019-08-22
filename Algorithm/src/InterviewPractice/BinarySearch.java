package InterviewPractice;

public class BinarySearch<E extends Comparable<E>> {

    public boolean binarySearch(E[] data, E target){
        if(data == null) throw new IllegalArgumentException("array is empty");

        int low = 0;
        int high = data.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(data[mid].compareTo(target) > 0){
                high = mid - 1;
            }else if(data[mid].compareTo(target) < 0){
                low = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] array = {1,3,4,5,7,8,9};
        BinarySearch solver = new BinarySearch();
        System.out.println(solver.binarySearch(array, 6));

//        StringBuilder
//                StringBuffer

        int N = 1024*1024;
        String s = "";
        for (int i=0; i < N; i++){
            s += 'q';
        }
//        String str = new String(chArray);
    }
}
