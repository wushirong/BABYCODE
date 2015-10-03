public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> record = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            if(record.containsKey(s.charAt(i))) {
                if(record.get(s.charAt(i)) != t.charAt(i)) {
                return false;
                }
                else continue;
            }
            else{
            record.put(s.charAt(i), t.charAt(i));
            }
        }
        record = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            if(record.containsKey(t.charAt(i))) {
                if(record.get(t.charAt(i)) != s.charAt(i)) {
                return false;
                }
                else continue;
            }
            else{
            record.put(t.charAt(i), s.charAt(i));
            }
        }
            
        return true;
    }
}