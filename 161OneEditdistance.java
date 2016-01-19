public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < s.length() && i < t.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length() - t.length() == 1) return s.substring(i + 1).equals(t.substring(i));
                else if(t.length() - s.length() == 1) return s.substring(i).equals(t.substring(i + 1));
                else if(t.length() == s.length()) return s.substring(i + 1).equals(t.substring(i + 1));
            }
                
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
//simplified version. Remember to put parantheses for :(s.length() >= t.length()? 1:0)
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        for(int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                return s.substring(i + (s.length() >= t.length()? 1:0)).equals(t.substring(i + (t.length() >= s.length()? 1:0)));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}