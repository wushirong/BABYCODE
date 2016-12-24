public  boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        int[] visited = new int[sum/2+1];
        for (int num: nums) if (num <= sum/2) visited[num]++;
        Arrays.sort(nums);
        return helper(visited, nums, sum/2, nums.length-1);
    }

    private  boolean helper(int[] visited, int[] nums, int target, int right) {
        if (target == 0) return true;
        if (target < 0 || right < 0) return false;
        for (int i =  right; i >= 0; i--) {
            if (target < nums[i] || visited[nums[i]] <= 0) continue;
            visited[nums[i]]--;
            if ( helper(visited, nums, target-nums[i], i) ) return true;
        }
        return false;
    }