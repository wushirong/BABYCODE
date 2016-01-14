//单纯使用recursive会TLE

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s == null || wordDict == null) return res;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(wordDict.contains(s.substring(i))) break;
            else if( i == 0) return res;
        }
        
        for(int i = 1; i <= s.length(); i++) {
            if(wordDict.contains(s.substring(0, i))) {
                List<String> list = wordBreak(s.substring(i), wordDict);
                if(list.size() != 0) {
                    for(String item: list) {
                        res.add(s.substring(0, i) + " " + item);
                    }
                }
            }
        }
        if(wordDict.contains(s)) res.add(s);
        return res;
    }
}