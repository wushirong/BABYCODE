public  List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() < words[0].length()) return new ArrayList<Integer>();
        int len = words[0].length();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(String word: words) {
            if(dict.containsKey(word)) dict.put(word, dict.get(word) + 1);
            else dict.put(word, 1);
        }
        
        for (int i = 0; i <= s.length() - len * words.length; i++)  {
            HashMap<String, Integer> copy = new HashMap<String, Integer>(dict);
            if(find(s.substring(i, i + words.length * len), copy, len))  res.add(i);
        }
        return res;
    }
    
    private  boolean find(String s, HashMap<String, Integer> dict, int len) {
        for(int i = 0; i < s.length(); i+= len) {
            String cur = s.substring(i, i + len);
            if(!dict.containsKey(cur) || dict.get(cur) == 0) return false;
            else dict.put(cur, dict.get(cur) - 1);
        }
        for(String key: dict.keySet()) {
            if (dict.get(key) != 0) return false;
        }
        return true;
    }

//second rewrite -- failed
public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0) return res;
        int wordlen = words[0].length();
        int count = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String str: words) {
            if(map.containsKey(str)) map.put(str, map.get(str) + 1);
            else map.put(str, 1);
        }
        
        for(int i = 0; i < wordlen; i++) {
            int left = i;
            HashMap<String, Integer> curmap = new HashMap<String, Integer>();                    
            count = 0;
            for(int j = i; j <= s.length() - wordlen; j += wordlen) {
                String str = s.substring(j, j + wordlen);
                if(map.containsKey(str)) {
                    if(curmap.containsKey(str)) curmap.put(str, curmap.get(str) + 1);
                    else curmap.put(str,1);
                    
                    if(curmap.get(str) > map.get(str)) {
                        while(curmap.get(str) > map.get(str)) {
                            String delete = s.substring(left, left + wordlen);
                            if(curmap.containsKey(delete)) {
                                curmap.put(delete, curmap.get(delete) - 1);
                                if(curmap.get(delete)<map.get(delete)) count--;
                            }
                            left += wordlen;
                        }
                    }
                    else count++;
                    
                    if(count == words.length) {
                        res.add(left);
                        String delete = s.substring(left, left + wordlen);
                        if(curmap.containsKey(delete)) {
                            curmap.put(delete, curmap.get(delete) - 1);
                            count--;
                        }
                        left += wordlen;
                    }
                }
                else {
                    count = 0;
                    curmap.clear();
                    left = j + wordlen;
                }
            }
        }
        return res;
    }