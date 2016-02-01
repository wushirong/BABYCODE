//recursive 
public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0) return false;
        int l = num.length();
        for(int i = 1; i <= l / 2; i++ ) {
            //num1 can't begin with 0
            if(num.charAt(0) == '0' && i >= 2) break;
            for(int j = i + 1; (l - j >= j - i) && (l - j >= i); j++ ) {
                if(num.charAt(i) == '0' && j - i >= 2) break;
                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                String substr = num.substring(j);
                if(helper(num1, num2, substr)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(long num1, long num2, String str) {
        if(str.length() == 0) return true;
        
        long sum = num1 + num2;
        String strSum = ((Long)sum).toString();
        if(! str.startsWith(strSum)) return false;
        return helper(num2, sum, str.substring(strSum.length()));
    }

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