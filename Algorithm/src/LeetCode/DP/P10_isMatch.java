package LeetCode.DP;

public class P10_isMatch {
    public boolean isMatch(String s, String p) {
        char[] chStr = s.toCharArray();
        char[] pStr = p.toCharArray();
        return isMatch(chStr, 0, chStr.length, pStr, 0, pStr.length);
    }

    private boolean isMatch(char[] chStr, int start1, int end1, char[] pStr, int start2, int end2) {
        int s = start1;
        int p = start2;

        while (s < chStr.length && p < pStr.length) {
            if (pStr[p] == '*') {

                if (pStr[p - 1] == '.') {
                    if (p + 1 == pStr.length) {
                        return true;
                    } else {
                        while (s < chStr.length) {
                            if (isMatch(chStr, s, end1, pStr, p + 1, end2)) {
                                return true;
                            }else{
                                s++;
                            }
                        }
                        return false;
                    }
                } else {
                    if (p + 1 == pStr.length) {
                        while (s < chStr.length && chStr[s] == pStr[p - 1]) {
                            s++;
                        }
                        if (s == chStr.length) return true;
                        else return false;
                    } else if (isMatch(chStr, s, end1, pStr, p + 1, end2))
                        return true;
                    else if (pStr[p - 1] == chStr[s]) {
                        while (s + 1 < chStr.length) {
                            if (isMatch(chStr, s + 1, end1, pStr, p + 1, end2)) {
                                return true;
                            } else {
                                s++;
                            }
                        }
                    } else {
                        return false;
                    }
                }

            } else {
                if (pStr[p] == '.' || chStr[s] == pStr[p]) {
                    s++;
                    p++;
                } else {
                    if (p + 1 < pStr.length && pStr[p + 1] == '*') {
                        return p + 2 < pStr.length ? isMatch(chStr, s, end1, pStr, p + 2, end2) : false;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (s == chStr.length && p == pStr.length || (p + 1 == pStr.length - 1 && pStr[p + 1] == '*')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        P10_isMatch solution = new P10_isMatch();
        String s = "aab";
        String p = "c*a*b";
        System.out.println(solution.isMatch(s, p));
    }
}
