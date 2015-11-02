public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0 || s.length() > 12) return res;
        helper(1, 0, s, "", res);
        return res;
    }
    private void helper(int index, int num, String s, String item, List<String> res) {
        if(index > s.length()) return;
        if(index == 4) {
            String adding = s.substring(num);
            if(isValid(adding)) res.add(item + '.' + adding);
            return;
        }
        for(int i = 1; i < 4 && i + num < s.length(); i++) {
            String subStr = s.substring(num, num + i);
            if(isValid(subStr)) {
                if(index == 1)  helper(index + 1, num + i, s, item + subStr, res);
                else  helper(index + 1, num + i, s, item + '.' +subStr, res);
            }
        }
    }
    private boolean isValid(String seg) {
        if(seg.length() < 1 || seg.length() > 3) return false;
        if(seg.charAt(0) == '0' && seg.length() > 1) return false;
        if(Integer.parseInt(seg) > 255 || Integer.parseInt(seg) < 0) return false;
        return true;
    }
}