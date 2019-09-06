package LeetCode.String;

public class P1108_defangIPaddr {
    public String defangIPaddr(String address) {
        String[] strs = address.split("\\.");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length - 1; i++){
            sb.append(strs[i]);
            sb.append("[.]");
        }
        sb.append(strs[strs.length - 1]);
        return sb.toString();
    }
    public String defangIPaddr1(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < address.length(); i++){
            if(address.charAt(i) == '.'){
                sb.append("[.]");
            }else{
                sb.append(address.charAt(i));
            }
        }
        return  sb.toString();
    }


    public static void main(String[] args) {
        String str = "1.1.1.1";
        P1108_defangIPaddr solver = new P1108_defangIPaddr();
        String res = solver.defangIPaddr1(str);
        System.out.println(res);
    }
}
