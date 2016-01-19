//simplified version, remember the useage of "\\s+"
//"\\s+" represents one or multiple white space, "\\s" represents one white space
public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] str = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length - 1; i > 0; i--) {
            sb.append(str[i] + " ");
        }
        sb.append(str[0]);
        return sb.toString();
    }

public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        List<String> list = new ArrayList<String>();
        StringBuilder word = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                if(word.length() != 0) {
                    list.add(word.toString());
                    word = new StringBuilder();
                }
                else continue;
            }
            else word.append(s.charAt(i));
        }
        if(word.length() > 0) list.add(word.toString()); // add last word into list
        
        if(list.size() > 0) {    // in case if list is empty
            for(int i = list.size() - 1; i > 0; i--) {
                res.append(list.get(i) + ' ');
            }
            res.append(list.get(0));
        }
        return res.toString();
    }
}