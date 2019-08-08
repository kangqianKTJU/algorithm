package nowCoder;

import java.rmi.MarshalException;

/**
 * Pro 65:请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath_65 {

    // 1.回溯法
    //
    // 1.查看当前节点是否和字符串的i个节点匹配，如果节点不存在或者节点与str[i]不相等，或当前节点已经访问过了，
    // 则说明这条路行不通
    // 2. 若该节点符合且为str已经匹配到结尾，则找到k
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        // 记录节点是否访问了
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < visited.length; i++) visited[i] = false;

        // 以每一个节点为起始节点，计算看是否存在路径
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(checkPath(matrix, rows, cols, i, j, str, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix  矩阵
     * @param rows  矩阵行数
     * @param cols  矩阵列数
     * @param i   起始点行坐标
     * @param j   起始点列坐标
     * @param str  字符串路径
     * @param k  字符串的第几个字符
     * @param visited  访问记录矩阵
     * @return
     */
    private boolean checkPath(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] visited) {

        int index = i * cols + j;


        if(i < 0 || i >= rows || j < 0 || j >= cols || str[k] != matrix[index] || visited[index] == true)
            return false;
        if(k == str.length - 1) return true;
        visited[index] = true;
        if(checkPath(matrix, rows, cols, i - 1, j, str, k + 1, visited) ||
                checkPath(matrix, rows, cols, i + 1, j, str, k + 1, visited) ||
                checkPath(matrix, rows, cols, i, j - 1, str, k + 1, visited) ||
                checkPath(matrix, rows, cols, i, j + 1, str, k + 1, visited)
        ){
            return true;
        }
        visited[index] = false;
        return  false;
    }
}
