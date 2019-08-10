package nowCoder;

public class TestCode {
    public static void main(String[] args) {
        int[] array1 = {1,3,5};
        int[] array2 = {77,21,1,3,5,7};
        System.out.println(compareArray(array1, array2));
    }

    public static int compareArray(int[] array1, int[] array2){
        int lengthArr1 = array1.length;
        int lengthArr2 = array2.length;
        int leastLength = lengthArr1 < lengthArr2 ? lengthArr1 : lengthArr2;

        int count = 0;
        for(int i = 1; i <= leastLength; i++){
            if(array1[lengthArr1 - i] != array2[lengthArr2 - i]){
                ++count;
            }
        }
        return count;
    }
}
