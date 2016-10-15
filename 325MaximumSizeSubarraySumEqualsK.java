public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (!map.containsKey(sum)) map.put(sum, i);
            if(sum == k) res = Math.max(res, i + 1 );
            else if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k) );
            }
        }
        return res;
    }