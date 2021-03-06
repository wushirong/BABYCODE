// recursive solution, for each "(", give a ")" to ensure each pair of paranthesis is closed.
public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n < 0) return res;
        helper(res, n, 0, 0, "");
        return res;
    }
    private void helper(List<String> res, int max, int left, int right, String path) {
        if(path.length() == 2 * max) {
            res.add(path);
            return;
        }
        if(left < max) helper(res, max, left + 1, right, path + "(");
        if(right < left) helper(res, max, left, right + 1, path + ")");
    }



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