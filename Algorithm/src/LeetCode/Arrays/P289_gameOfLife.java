package LeetCode.Arrays;


import javax.swing.*;

public class P289_gameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] newBoard = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int stateNum = stateNum(board, rows, cols, i, j);
                if(stateNum == 3)
                    newBoard[i][j] = 1;
                else if(stateNum < 2 || stateNum > 3)
                    newBoard[i][j] = 0;
                else
                    newBoard[i][j] = board[i][j];
            }
        }
        for(int i = 0;i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = newBoard[i][j];
            }
        }
    }

    private int stateNum(int[][] states, int rows, int cols, int row, int col){
        int stateSum = 0;
        for(int i = row - 1; i <= row + 1; i++){
            for(int j = col - 1; j <= col + 1; j++){
                if(i >= 0 && i < rows && j >= 0 && j < cols && !(i == row && j == col) && states[i][j] == 1){
                    stateSum ++;
                }
            }
        }
        return stateSum;
    }

    public static void main(String[] args) {
        P289_gameOfLife solver = new P289_gameOfLife();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solver.gameOfLife(board);
        for(int i = 0;i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
