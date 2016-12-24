//using 32 bit int to record the appearance of 26 characters in a string
public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int len = words.length;
        int[] record = new int[len];
        for (int i = 0; i < len; i++) {
            for (char ch: words[i].toCharArray()) {
                record[i] |= 1 << (ch-'a');
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if ((record[i] & record[j]) == 0) max = Math.max(max, words[i].length()*words[j].length());
            }
        }
        return max;
    }