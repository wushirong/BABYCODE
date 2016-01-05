public class Solution {
    public int titleToNumber(String s) {
        if(s == null) return -1;
        if(s.length() == 1) return s.charAt(0) - 'A' + 1;
        else {
            int sum = 0;
            for(int i = 0; i < s.length(); i++) {
                sum = sum * 26 + (s.charAt(i) - 'A' +1);
            }
            return sum;
        }
    }
}