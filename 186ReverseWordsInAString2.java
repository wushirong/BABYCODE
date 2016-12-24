public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        int len = s.length;
        reverse(s, 0, len-1);
        int l = 0, r = -1;
        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                reverse(s, l, i-1);
                l = i+1;
            }
        }
        reverse(s, l, len-1);
    }
    
    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }