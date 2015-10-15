//solution stack overflow
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return true;
        
        s = s.trim();
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-z]+", "");
        return isPalindrome(s, 0, s.length());
    }
    private boolean isPalindrome(String s, int start, int end) {
        if(start >= end) return true;
        return s.charAt(start) == s.charAt(end-1)? isPalindrome(s, start + 1, end - 1): false;
    }
}
// solution accepted 1
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return true;
        
        s = s.trim();
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-z]+", "");
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}