    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        Queue<Character> queue = new LinkedList<Character>();
        int[] chars = new int[256];
        int count = 0;
        int len = s.length();
        int max = 0;
        int index = 0;
        while (index < len) {
            char cur = s.charAt(index);
            if (!queue.contains(cur)) {
                if (count < k) count++;
                else {
                    while (!queue.isEmpty() && chars[queue.peek()] > 0) {
                        if (--chars[queue.poll()] == 0) break;
                    }
                }
            }
            queue.offer(cur);
            chars[(int)cur]++;
            index++;
            max = Math.max(queue.size(), max);
        }
        return max;
    }


public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) return 0;
        int[] chars = new int[256];
        Queue<Character> queue = new LinkedList<Character>();
        int size = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(size < k && !queue.contains(cur)) {
                size++;
                
            } 
            else {
                if(chars[cur - 0] == 0) {
                    max = Math.max(max, queue.size());
                    while(!queue.isEmpty() && chars[queue.peek() - 0] > 0) {
                        chars[queue.peek() - 0]--;
                        if(chars[queue.poll() - 0] == 0) break;
                    }
                }
            }
            queue.offer(cur);
            chars[cur - 0]++;
            max = Math.max(max, queue.size());
        }
        return max;
    }