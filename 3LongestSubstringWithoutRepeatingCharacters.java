public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int maxlen = 0;
        int lo = 0;
        int hi = 0;
        HashSet<Character> set = new HashSet<Character>();
        while(hi < s.length()) {
            if(! set.add(s.charAt(hi))) {
                maxlen = hi - lo > maxlen? hi - lo : maxlen;
                while( s.charAt(lo) != s.charAt(hi)) {
                    set.remove(s.charAt(lo));
                    lo++;
                }
                lo++;
            }
            hi++;
        }
        maxlen = maxlen > hi - lo? maxlen : hi - lo;
        return maxlen;
    }
}