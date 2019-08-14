package LeetCode.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class P51_solveNQueens {

    int rows[];
    int hills[];
    int dales[];

    int n;
    List<List<String>> output = new ArrayList<>();
    int queens[];

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return  output;
    }

    private void backtrack(int row) {
        for(int col = 0; col < n; col++){
            if(isNotUnderAttack(row, col)){
//                placeQueue(row, col);
//                if(row == n - 1) addSolution();
//                else{
//                    backtrack(row + 1);
//                }
//                removeQueue(row, col);
            }
        }
    }

    private boolean isNotUnderAttack(int row, int col) {
        return  true;
    }


}
