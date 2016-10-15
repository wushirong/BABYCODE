public String rearrangeString(String str, int k) {
        if(k == 0 || str.length() < k) return str;
        int[] count = new int[26];
        int[] track = new int[26];
        int len = str.length();
        for(char ch: str.toCharArray()) {
            count[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            int index = helper(count, track, i);
            if(index < 0) return "";
            count[index]--;
            track[index] += k;
            sb.append((char)('a' + index));
        }
        return sb.toString();
    }
    
    private int helper(int[] count, int[] track, int index) {
        int max = Integer.MIN_VALUE;
        int pos= -1;
        for(int i = 0; i < track.length; i++) {
            if(count[i] > 0 && count[i] > max && track[i] <= index) {
                max = count[i];
                pos = i;
            }
        }
        return pos;
    }