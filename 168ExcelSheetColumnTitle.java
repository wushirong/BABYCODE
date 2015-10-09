public class Solution {
    public String convertToTitle(int n) {
        char[] column = {'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
        StringBuilder res = new StringBuilder();
        int num = n;
        if(n < 0) return res.toString();
        
        while(num > 0) {
            res.append(column[num%26]);
            num = (num - 1) / 26;
        }
        
        return res.reverse().toString();
    }
}