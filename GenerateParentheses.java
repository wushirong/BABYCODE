public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n == 0) return res;
        res.add("()");
        
        for(int i = 1; i < n; i++) {
            int length = res.size();
            for(int j = 0; j < length; j++) {
                String content = res.get(0);
                res.remove(0);
                res.add("(" + content + ")");
                res.add("()" + content);
                if(!res.contains(content + "()")) res.add(content + "()");
            }
        }
        return res;
    }
}