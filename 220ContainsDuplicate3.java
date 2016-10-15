 public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        if (nums == null || nums.length == 0) return false;
        HashMap<Long, Long> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            long cur = (long)nums[i] - Integer.MIN_VALUE ;
            long bucket = cur / ((long)t + 1);
            if(map.containsKey(bucket) ||
               (map.containsKey(bucket - 1) && cur - map.get(bucket-1) <= t) ||
               (map.containsKey(bucket + 1) && map.get(bucket+1) - cur <= t)) return true;
            if(map.entrySet().size() >= k) {
                long last = ((long)nums[i-k] - Integer.MIN_VALUE)/((long)t+1);
                map.remove(last);
            }
            map.put(bucket, cur);
        }
        return false;
    }