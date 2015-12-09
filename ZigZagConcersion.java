public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() <= 1 || numRows == 1 || s.length() < numRows) return s;
        StringBuilder res = new StringBuilder();
        int m = 2 * numRows - 2;
        for(int i = 0; i< numRows; i++) {
            for(int j = i; j < s.length(); j = j + m) {
                res.append(s.charAt(j));
                if(i!=0&&i!=numRows-1&&j+m-2*i<s.length())
					res.append(s.charAt(j+m-2*i));
            }
        }
       return res.toString();
    }
}