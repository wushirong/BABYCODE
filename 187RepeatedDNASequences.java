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