//simplified version
public class Solution {
    HashMap<Character, String> map = new HashMap<Character, String>();
    HashSet<String> set = new HashSet<String>();
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.isEmpty()) return str.isEmpty();
        char key = pattern.charAt(0);
        if(map.containsKey(key)) {
            String value = map.get(key);
            if(value.length() > str.length() || !str.substring(0, value.length()).equals(value))
                return false;
            if(wordPatternMatch(pattern.substring(1), str.substring(value.length()))) return true;
        }
        else {
            for(int i = 1; i <= str.length(); i++) {
                String value = str.substring(0, i);
                if(set.contains(value)) continue;
                map.put(pattern.charAt(0), value);
                set.add(value);
                if(wordPatternMatch(pattern.substring(1), str.substring(i))) return true;
                map.remove(pattern.charAt(0));
                set.remove(value);
            }
        }
        return false;
    }
}

//用一个hashmap记录key和value对应值，用hashset检查是否有两个key对应了同一个value，如果有，则尝试为第二个key换value

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length() == 0 && str.length() == 0) return true;
        if(pattern == null || pattern.length() == 0 || str == null || str.length() == 0) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> set = new HashSet<String>();
        
        return helper(map, set, pattern, str);
    }
    
	private boolean helper(HashMap<Character, String> map, HashSet<String> set, String pattern, String str) {
        if(pattern.length() == 0 && str.length() == 0) return true;
        else if(pattern.length() == 0 || str.length() == 0) return false;
        else if(map.containsKey(pattern.charAt(0))) {
            if(!str.startsWith(map.get(pattern.charAt(0)))) return false;
            else return helper(map, set, pattern.substring(1), str.substring(map.get(pattern.charAt(0)).length()));
        }
        else {
        	for(int i = 1; i <= str.length(); i++) {
                String value = str.substring(0, i);
                if(set.contains(value)) continue;
                else {
                    set.add(value);
                    map.put(pattern.charAt(0), value);
                    if(helper(map, set, pattern.substring(1), str.substring(i))) return true ;
                    else {
                    	map.remove(pattern.charAt(0));
                    	set.remove(value);
                    }
                }
            }
        }
        return false;
    }
}