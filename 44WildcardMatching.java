public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        int nums = 0;
        int nump = 0;
        int start = -1;
        int match = -1;
        while(nums < s.length()) {
            if(nump < p.length() && (s.charAt(nums) == p.charAt(nump) || p.charAt(nump) == '?') ) {
                nums++;
                nump++;
            }
            else if(nump < p.length() && p.charAt(nump) == '*') {
                start = nump;
                match = nums;
                nump++;
            }
            else if(start != -1) {
                nump = start + 1;
                match++;
                nums = match;
            }
            else return false;
        }    
        while(nump < p.length() && p.charAt(nump) == '*') nump++;
        return nump == p.length();
    }
}