//n^2 solution TLE
public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int step = 1;
        if(beginWord == null || beginWord.length() == 0 || beginWord.equals(endWord)) return 0;
        HashSet<String> record = new HashSet<String>();
        record.add(beginWord);
        wordList.add(endWord);
        while(!record.contains(endWord)) {
            HashSet<String> curset = new HashSet<String>();
            for(String each: record) {
                for(int i = 0; i < each.length(); i++) {
                    char[] cha = each.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        cha[i] = ch;
                        String newstr = new String(cha);
                        if(wordList.contains(newstr)) {
                            curset.add(newstr);
                            wordList.remove(newstr);
                        }
                    }
                }
            }
            step++;
            if(curset.size() == 0) return 0;
            record = curset;
        }
        return step;
    }