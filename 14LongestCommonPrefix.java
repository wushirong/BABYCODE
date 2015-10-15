public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int index = 0;
        StringBuilder res = new StringBuilder();
        
        while(strs[0].length() > 0) {
            for(int i = 1; i < strs.length; i++) {
                if(index >= strs[i].length() || index >= strs[0].length()) {
                    return res.toString();
                }
                else if(strs[0].charAt(index) != strs[i].charAt(index)) {
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(index));
            index++;
        }
        return res.toString();
    }
}