//genious solution
public boolean isStrobogrammatic(String num) {
        for(int i = 0, j = num.length() - 1; i <= j; i++,j--) {
            if(!("00 11 88 696").contains(num.charAt(i) + "" + num.charAt(j))) return false;
        }
        return true;
    }

public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        int l = num.length();
        if(l == 1) {
            if(num.charAt(0) != '1' && num.charAt(0) != '8' && num.charAt(0) != '0') return false;
            else return true;
        }
        
        for(int i = 0; i < l / 2; i++) {
            char cur = num.charAt(i);
            if(cur == '1' || cur == '8' || cur == '0') {
                if(num.charAt(l-1-i) != cur) return false;
            }
            else if(cur == '6') {
                if(num.charAt(l-1-i) != '9') return false;
            }
            else if(cur == '9') {
                if(num.charAt(l-1-i) != '6') return false;
            }
            else return false;
        }
        if(l % 2 == 1 && (num.charAt(l/2) != '1' && num.charAt(l/2) != '8' && num.charAt(l/2) != '0')) return false;
        return true;
    }