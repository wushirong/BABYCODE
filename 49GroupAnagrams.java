public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return null;
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] strC = strs[i].toCharArray();
            Arrays.sort(strC);
            String str = String.valueOf(strC);
            if(! map.containsKey(str)) {
                List<String> list1 = new ArrayList<String>();
                list1.add(strs[i]);
                map.put(str, list1);
            }
            else {
                List<String> list2 = map.get(str);
                list2.add(strs[i]);
                map.put(str, list2);
            }
        }
        for(List<String> item : map.values()){
            Collections.sort(item);
            res.add(item);
        }
        return res;
    }
}