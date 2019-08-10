package nowCoder;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix_19 {

    // 1. 将矩阵分为四圈，分别进行打印，打印的时候记住要去除重复的元素
    // 2. 当第一次打印或第三打印的的是同一行时，解释，避免重复打印；当第二次打印和打印是同一列的时候，停止打印

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null) return res;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int circle = rows < cols ? (rows + 1) / 2 :(cols + 1) / 2;

        for(int i = 0; i < circle; i++){
            for(int j = i; j < cols - i; ++j){
                res.add(matrix[i][j]);
            }

            for(int j = i + 1; j < rows - i; ++j){
                res.add(matrix[j][cols - 1 - i]);
            }

            for(int j = cols - 2 - i; j >= i ; j--){
                if(rows - 1 - i == i) return res;
                res.add(matrix[rows - 1 -i][j]);
            }

            for(int j = rows - 2 - i; j > i; j--){
                if(cols - 1 - i == i) return res;
                res.add(matrix[j][i]);
            }
        }
        return res;
    }
}
