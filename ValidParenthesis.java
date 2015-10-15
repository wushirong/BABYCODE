public class Solution {
    public boolean isValid(String s) {
        if(s == null) return true;
        Stack<Character> res = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                res.push(c);
            }
            else if(res.isEmpty()) return false;
            else {
                char cc = res.pop();
                switch(c) {
                case ')' :
                    if(cc != '(') return false;
                    break;
                case ']' :
                    if(cc != '[') return false;
                    break;
                case '}' :
                    if(cc != '{') return false;
                    break;
                }
            }
        }
        return res.isEmpty()?true : false;
    }
}