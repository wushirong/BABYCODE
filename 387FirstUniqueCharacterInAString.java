public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int len = s.length();
        int[] visited = new int[26];
        int[] position = new int[26];
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            visited[cur-'a']++;
            position[cur-'a'] = i;
        }
        int res = -1;
        for (int i = 0; i < 26; i++) if (visited[i] == 1) res = res < 0? position[i]: Math.min(res, position[i]);
        return res;
    }