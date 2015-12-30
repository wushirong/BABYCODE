public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0) return false;
        String a = "";
        String b = "";
        for(int i = 1; i <= num.length()/3; i++) {
            a = num.substring(0, i);
            if(a.charAt(0) == '0' && a.length() > 1) break;
            for(int j = i+1; j < num.length(); j++) {
                b = num.substring(i, j);
                if(b.charAt(0) == '0' && b.length() > 1) continue;
                if(helper(num.substring(j), a, b)) return true;
            }
        }
        return false;
    }
    
    public boolean helper(String num, String a, String b) {
        long num1 = Long.parseLong(a);
        long num2 = Long.parseLong(b);
        long s = num1 + num2;
        String sum = String.valueOf(s);
        if(sum.length() > num.length()) return false;
        if(sum.equals(num)) return true;
        if(sum.equals(num.substring(0, sum.length()))) return helper(num.substring(sum.length()), b, sum);
        return false;
    }
}