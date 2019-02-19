/*问题：
    在一个二维数组中（每个一维数组的长度相同），
    每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/

/*思路：
    根据二维数组的特点，从左下角元素开始查找
    若target小，则往小的方向找，即往上找
    若target大，则往大的方向找，即往右找
    直到索引到右上角还没找到，则说明元素不存在


    *   *   *   *         *    *   *   *        #    *   *   *          #    *   *   *
    *   *   *   *   →     *    *   *   *  →     #    *   *   *   →      #    $   *   *  ....
    *   *   *   *         $    *   *   *        #    $   *   *          #    #   #   #
    $   *   *   *         #    #   #   #        #    #   #   #          #    #   #   #

*/
public class Solution {
    public boolean Find(int target, int [][] array) {
        boolean result = false;
        int rows = array.length;
        int colmns = array[0].length;
        int i = rows -1;
        int j = 0;
        while (i >=0 && j < colmns){
            if (target > array[i][j])
                j++;
            else if (target < array[i][j])
                i--;
            else{
                result = true;
                break;
            }
        }
        return result;
    }
}