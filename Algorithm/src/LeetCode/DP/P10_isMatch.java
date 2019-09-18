package LeetCode.DP;

public class P10_isMatch {
    public boolean isMatch(String s, String p) {
        if(p == null || s == null) return false;
        return matchCore(s.toCharArray(), 0, s.length() - 1, p.toCharArray(), 0, p.length() - 1);
    }
    private boolean matchCore(char[] str, int lowS, int highS, char[] pattern, int lowP, int highP){
        if(lowP > highP && lowS > highS) return true;
        if(lowP > highP && lowS <= highS) return false;
        if(lowP == highP){
            if(lowS == highS && (str[lowS] == pattern[lowP] || pattern[lowP] == '.'))
                return true;
            else
                return false;
        }else{

            if(pattern[lowP + 1] == '*'){
                if(lowS <= highS && (str[lowS] == pattern[lowP] || pattern[lowP] == '.')){
                    return matchCore(str, lowS, highS, pattern, lowP + 2, highP) ||
                            matchCore(str, lowS+ 1, highS, pattern, lowP, highP) ||
                            matchCore(str, lowS + 1, highS, pattern, lowP + 2, highP);
                }else{
                    return matchCore(str, lowS, highS, pattern, lowP + 2, highP);
                }
            }

            if(lowS <= highS && (str[lowS] == pattern[lowP] || pattern[lowP] == '.')){
                return matchCore(str, lowS + 1, highS, pattern, lowP + 1, highP);
            }else{
                return false;
            }
        }
    }

    public boolean isMatch1(String s, String p) {
        if(p == null || s == null) return false;
        return isMatch(s.toCharArray(), 0, s.length() - 1, p.toCharArray(), 0, p.length() - 1);
    }
    private boolean isMatch(char[] str, int lowS, int highS, char[] pattern, int lowP, int highP){
        if(lowP > highP) return lowS > highS;

        boolean first_match = (lowS <= highS  && (pattern[lowS] == str[lowS] || pattern[lowP] == '.'));

        if(lowP < highP && pattern[lowP + 1] == '*'){
            return (isMatch(str ,lowS, highS, pattern, lowP + 2, highP))
                    || (first_match && isMatch(str,lowS + 1, highS,pattern, lowP, highP));
        }else{
            return first_match && isMatch(str, lowS + 1, highS, pattern, lowP + 1, highP);
        }
    }

    public static void main(String[] args) {
        P10_isMatch solution = new P10_isMatch();
        String s = "ab";
        String p = ".*c";
        System.out.println(solution.isMatch1(s, p));
    }
}
