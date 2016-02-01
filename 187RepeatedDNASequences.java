//using combination of hashmap and bit moving to save space, using O(n) time
public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        HashSet<Integer> first = new HashSet<Integer>();
        HashSet<Integer> second = new HashSet<Integer>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            int hash = helper(s.substring(i, i + 10));
            if(! first.add(hash) && second.add(hash)) res.add(s.substring(i, i + 10));
        }
        return res;
    }
    private int helper(String str) {
        char[] map = new char[26];
        int hash = 0;
        if(str.length() != 10) return -1;
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for(int i = 0; i < str.length(); i++) {
            int temp = map[str.charAt(i) - 'A'];
            hash = hash << 2;
            hash = hash|temp;
        }
        return hash;
    }

//common solution using hashmap, using O(n) time and O(n) space
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<String>();
        List<String> res = new LinkedList<String>();
        if(s.length() < 10) return res;
        for(int i = 0; i < s.length() - 9; i++) {
            String target = s.substring(i, i + 10);
            if(set.contains(target) && !res.contains(target)) res.add(target);
            else set.add(target);
        }
        return res;
    }
}