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