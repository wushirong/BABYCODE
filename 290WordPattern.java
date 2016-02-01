public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null) return false;
        HashMap< Character, String> map = new HashMap<Character, String>();
        String[] value = str.split(" ");
        char[] key = pattern.toCharArray();
        if(key.length != value.length) return false;
        for(int i = 0; i < key.length; i++) {
            if(map.containsKey(key[i])) {
                //using equals is important
                if(!map.get(key[i]).equals(value[i]) ) return false;
            }
            else {
                if(map.containsValue(value[i])) return false;
                else map.put(key[i], value[i]);
            }
        }
        return true;
    }
}