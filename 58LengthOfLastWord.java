public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        s = s.toLowerCase();
        int count = 0;
        
        for(int i = s.length() - 1 ; i >= 0; i--) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') count++;
            else break;
        }
        return count;
    }
}