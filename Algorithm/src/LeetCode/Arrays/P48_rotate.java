package LeetCode.Arrays;

public class P48_rotate {

    // 1. 由内向外旋转移动
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n - i - 1; j++){
                int dis = j - i;
                int len = n - 1 - i;
                swap(matrix, i, j, i + dis, len);
                swap(matrix, i, j, len, len - dis);
                swap(matrix, i, j,len -dis, i);
            }
        }
    }
    private void swap(int[][] matrix, int i1, int j1, int i2, int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];;
        matrix[i2][j2] = temp;
    }

    // 2. 转置 + 翻转

    public static void main(String[] args) {
        P48_rotate solver = new P48_rotate();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solver.rotate(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j <matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
