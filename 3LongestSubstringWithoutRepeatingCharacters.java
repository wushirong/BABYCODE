public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        int[] record = new int[256];
        Arrays.fill(record, -1);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (record[ch] < 0 || record[ch] < start) {
                if (i == s.length()-1) max = Math.max(max, i-start+1);
                else record[ch] = i;
            }
            else {
                max = Math.max(max, i-start);
                start = record[ch]+1;
                record[ch] = i;
            }
        }
        return max;
    }


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