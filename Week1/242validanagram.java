public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null){
            return true;
        }
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> checking = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(checking.containsKey(c)){
                int num = checking.get(c) + 1;
                checking.put(c, num);
            } else {
                checking.put(s.charAt(i), 1);
            }
        }
        for(int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if(checking.containsKey(c)){
                int num = checking.get(c) - 1;
                if(num < 0) return false;
                checking.put(c, num);
            }
            else {
                return false;
            }
        }
        return true;
    }
}