package LeetCode.Hash;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class P771_numJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        long hash = 0;
        for(int i = 0; i < J.length(); i++){
            char ch = J.charAt(i);
            if(ch <= 'z' && ch >= 'a'){
                hash |= (1L << (ch - 'a'));
            }else{
                hash |= (1L << (ch - 'A' + 26));
            }
        }

        int count = 0;
        for(int j = 0; j < S.length(); j++){
            char ch = S.charAt(j);
            if(ch <= 'z' && ch >= 'a'){
                if((hash & (1L << (ch - 'a'))) != 0) ++count;
            }else{
                if((hash & (1L << (ch - 'A' + 26))) != 0) ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        P771_numJewelsInStones solution = new P771_numJewelsInStones();
        String J = "aNE";
        String S = "xGID";
        System.out.println(solution.numJewelsInStones(J, S));
    }
}
