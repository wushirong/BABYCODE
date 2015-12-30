public class Solution {
    public List<String> generateParenthesis(int n) {
        if(n < 0) return null;
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> unit = new ArrayList<String>();
        unit.add("");
        list.add(unit);
        for(int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<String>();
            for(int j = 0; j < i; j++) {
                for(String before: list.get(j)) {
                    for(String after: list.get(i - j - 1)) {
                        cur.add("(" + before + ")" + after);
                    }
                }
            }
            list.add(cur);
        }
        return list.get(list.size() - 1);
    }

}