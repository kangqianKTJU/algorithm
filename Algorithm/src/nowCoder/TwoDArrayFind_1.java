package nowCoder;

/**
 * 题目 1： 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */


// 1.分界线法
// 从右上角（或左下角）进行查找，如果小于target,则往下找，若大于target,则往左找，知道超过数组范围
public class TwoDArrayFind_1 {
    public boolean Find(int target, int[][] array) {
        // 分界线法
        if (array == null) return false;
        int rows = array.length;
        int columns = array[0].length;

        int row = 0;
        int col = columns - 1;
        while (row < rows && col >= 0) {
            if (array[row][col] == target) {
                return true;
            }
            if (array[row][col] > target) {
                --col;
            } else {
                ++row;
            }
        }
        return false;
    }
}
//2. 暴力法：略
