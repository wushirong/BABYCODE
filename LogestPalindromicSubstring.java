public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return null;
        String res = null;
        int maxLen = 0;
        for(int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i/2;
            int right = i/2;
            if(i%2 == 1) right++;
            String palin = helper(s, left, right);
            if(maxLen < palin.length()) {
                maxLen = palin.length();
                res = palin;
            }
        }
        return res;
    }
    private String helper(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);  
        
    }
}