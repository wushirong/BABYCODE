public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return "";
        
        int[] res = new int[26];
        boolean[] visited = new boolean[26];
        for(char c: s.toCharArray()) {
            res[c - 'a'] ++;
            
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()) {
            int cur = ch - 'a';
            res[cur]--;
            if(visited[cur]) continue; 
            while((sb.length() > 0) && (ch < sb.charAt(sb.length() - 1)) && res[sb.charAt(sb.length() - 1) - 'a'] != 0 ) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(ch);
            visited[cur] = true;
        }
        
        return sb.toString();
    }


public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return "";
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int index = s.charAt(i) - 'a';
            count[index]--;
            if(visited[index]) continue;
            while(!stack.isEmpty() && cur < stack.peek() && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(cur);
            visited[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        } 
        return sb.toString();
    }