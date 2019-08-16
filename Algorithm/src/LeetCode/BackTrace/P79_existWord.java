package LeetCode.BackTrace;

import jdk.nashorn.internal.ir.Flags;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 */
public class P79_existWord {

    //  1. 回溯算法模板
    //  依此从矩阵中取出一个元素作为开头和字符串进行比较，
    //  边界条件：索引超出矩阵范围，该位置的值和要对应的字符串中的字符不匹配，该位置已经别访问过
    //  终止条件：匹配到字符串的最后一个元素
    //  若还没匹配完，flag置为true,向该位置四周进行寻找,找到返回true,结束
    //  若没找到， flag置为flag,回溯置上一级。
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] flag = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(exist(board, rows, cols, i, j, flag, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int rows, int cols, int row, int col, boolean[][] flag, String word, int index){
        if(col < 0 || col >= cols || row < 0 || row >= rows
                || board[row][col] != word.charAt(index) || flag[row][col] == true){
            return false;
        }
        if(index == word.length() - 1) return true;
        flag[row][col] = true;

        if(exist(board, rows, cols, row + 1, col, flag, word, index + 1) ||
                exist(board, rows, cols, row - 1, col, flag, word, index + 1) ||
                exist(board, rows, cols, row, col - 1, flag, word, index + 1) ||
                exist(board, rows, cols, row, col + 1, flag, word, index + 1)
        ){
            return true;
        }else{
            flag[row][col] = false;
            return false;
        }

    }

    public static void main(String[] args) {
        P79_existWord solution = new P79_existWord();
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println(solution.exist(board, word));

    }
}
