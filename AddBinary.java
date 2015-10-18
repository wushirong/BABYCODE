public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        char ca = a.charAt(a.length()-1);
        char cb = b.charAt(b.length()-1);
        char c = '0';
        
        for(int i = 0; i < a.length() || i < b.length(); i++) {
            if(i > a.length() - 1) ca = '0';
            else ca = a.charAt(a.length() - i -1);
            if(i > b.length() - 1) cb = '0';
            else cb = b.charAt(b.length() - i -1);
            switch(add(ca, cb, c)) {
                case 3:
                    res.append(1);
                    c = '1';
                    break;
                case 2:
                    res.append(0);
                    c = '1';
                    break;
                case 1:
                    res.append(1);
                    c = '0';
                    break;
                case 0:
                    res.append(0);
                    c = '0';
                    break;
            }
        }
        
        if(c == '1') res.append(1);
        return res.reverse().toString();
    }
    public int add(char a, char b, char c) {
        if(a == '1' && b == '1' & c == '1') return 3;
        if(a == '0' && b == '1' & c == '1') return 2;
        if(a == '1' && b == '0' & c == '1') return 2;
        if(a == '1' && b == '1' & c == '0') return 2;
        if(a == '0' && b == '0' & c == '1') return 1;
        if(a == '0' && b == '1' & c == '0') return 1;
        if(a == '1' && b == '0' & c == '0') return 1;
        if(a == '0' && b == '0' & c == '0') return 0;
        return 0;
    }
}