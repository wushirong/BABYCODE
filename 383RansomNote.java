public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine == null || magazine.length() < ransomNote.length()) return false;
        int[] chs = new int[26];
        for(char ch: ransomNote.toCharArray()) chs[ch-'a']--;
        for(char ch: magazine.toCharArray()) chs[ch-'a']++;
        for(int each:chs) if(each < 0) return false;
        return true;
        
    }