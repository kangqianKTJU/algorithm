package nowCoder;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class ReplaceSpace_2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                res.append(str.charAt(i));
            }else{
                res.append("%20");
            }
        }
        return res.toString();
    }
}
/*
class Solution {
public:
	void replaceSpace(char *str,int length) {
        if(str == nullptr || length <= 0) return;
        int size = length;
        for(int i = 0; str[i] != '\0';){
            if(str[i] == ' '){
                size += 2;
                for(int j = size; j >= i + 3; j--){
                    str[j] = str[j - 2];
                }
                str[i] = '%';
                str[i + 1] = '2';
                str[i + 2] = '0';
                i += 3;
            }else{
                i++;
            }
        }
	}
};

 */

/**
 * void replaceSpace(char *str,int length) {
 *         if(str == nullptr || length <= 0) return;
 *         int size = length;
 *         for(int i = 0; i < length; i++){
 *             if(str[i] == ' ')
 *                 size += 2;
 *         }
 *
 *         int p1 = length;
 *         int p2 = size;
 *
 *         while(p1 < p2 && p1 >= 0){
 *             if(str[p1] ==  ' '){
 *                 str[p2--] = '0';
 *                 str[p2--] = '2';
 *                 str[p2--] = '%';
 *             }else{
 *                 str[p2--] = str[p1];
 *             }
 *             --p1;
 *         }
 *        }
 */
