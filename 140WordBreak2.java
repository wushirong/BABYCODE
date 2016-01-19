//单纯使用recursive会TLE，但是主要是为了handle过分复杂的corner case

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s == null || wordDict == null) return res;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(wordDict.contains(s.substring(i))) break;
            else if( i == 0) return res;
        } //这一步的主要目的是为了处理只有末尾不同的corner case
        
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