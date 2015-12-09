public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= s.length(); i++) {
            if(s.charAt(i-1) == '0') {
                if(Integer.parseInt(s.substring(i-2, i)) >26 || Integer.parseInt(s.substring(i-2, i)) < 10) return 0;
                else {
                    res[i] = res[i-2];
                    continue;
                }
            }
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) > 10) 
                res[i] = res[i-1] + res[i-2];
            else res[i] = res[i-1];
        }
        return res[s.length()];
    }
}