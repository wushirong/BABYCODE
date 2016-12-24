public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) continue;
            int left = map.containsKey(num-1)? map.get(num-1):0;   //important
            int right = map.containsKey(num+1)? map.get(num+1):0;
            int count = 1+left+right;
            map.put(num, count);
            map.put(num-left, count);
            map.put(num+right, count);
        }
        int res = Integer.MIN_VALUE;
        for (int key: map.keySet()) {
            res = Math.max(res, map.get(key));
        }
        return res;
    }