public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s ==  null || s.length() == 0) return 0;
        int max = 0;
        Queue<Character> queue = new LinkedList<Character>();
        int count = 0;
        for(char ch: s.toCharArray()) {
            if (!queue.contains(ch)) count++;
            queue.offer(ch);
            if (count > 2) {
                char dump = queue.peek();
                while (count > 2) {
                    if (!queue.contains(queue.poll())) count--;
                }
            }
            max = Math.max(max, queue.size());
        }
        return max;
    }