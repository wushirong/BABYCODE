//divide and conquer
public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        return helper(s.toCharArray(), 0, s.length(), k);
    }
    
    private int helper(char[] s, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) count[s[i]-'a']++;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            if (count[i] < k) {
                for (int j = start; j < end; j++) {
                    if (s[j] == i+'a') {
                        return Math.max(helper(s, start, j, k), helper(s, j+1, end, k));
                    }
                }
            }
        }
        return end - start;
    }