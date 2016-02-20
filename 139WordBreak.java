//using dynamic programming to reduce time complexity
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        boolean[] record = new boolean[s.length() + 1];
        record[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(record[j] && wordDict.contains(s.substring(j, i))) {
                    record[i] = true;
                    break;
                }
            }
        }
        
        return record[s.length()];
    }
}