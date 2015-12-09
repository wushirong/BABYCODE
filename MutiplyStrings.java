public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num1.charAt(0) == '0') return "0";
        if(num2 == null || num2.length() == 0 || num2.charAt(0) == '0') return "0";
        int n = num1.length();
        int m = num2.length();
        int sum = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= m+n; i++) {
            for(int j = 1; j <= Math.min(n, i); j++) {
                int k = i - j + 1;
                if(k <= m) sum += (num1.charAt(n - j) - '0') * (num2.charAt(m - k) - '0' ) ;
            }
            if(sum > 0 || i != n+m) res.append(sum % 10);
            sum /= 10;
        }
        return res.reverse().toString();
    }
}