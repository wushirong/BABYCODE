//divide and conquer
public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) return 0;
        
        return helper(s, 0, s.length(), k);
    }
    
    private int helper(String s, int start, int end, int k) {
        if (start >= end || end-start < k) return 0;
        int[] record = new int[26];
        int res = 0;
        for (char ch: s.substring(start, end).toCharArray()) record[ch-'a']++;
        for (int i = 0; i < 26; i++) {
            if (record[i] == 0) continue;
            else if (record[i] < k) {
                for (int j = start; j < end; j++) {
                    if (s.charAt(j) == (char)(i+'a')) {
                        res = Math.max(helper(s, start, j, k), helper(s, j+1, end, k));
                        return res;
                    }
                }
            }
        }
        return end-start;
    }