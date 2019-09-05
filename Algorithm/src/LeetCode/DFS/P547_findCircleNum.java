package LeetCode.DFS;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 */
public class P547_findCircleNum {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] flag = new int[n];
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(flag[i] == 0){
                stack.push(i);
                while(!stack.isEmpty()){
                    Integer num = stack.pop();
                    for(int j = 0; j < num; j++){
                        if(M[num][j] == 1 && flag[j] != 1) {
                            stack.push(j);
                            flag[j] = 1;
                        }
                    }
                }
            }
            count++;
        }
        String s = new String("kkq");

        return count;

    }
}
