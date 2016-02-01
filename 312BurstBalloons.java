public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] num = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) num[n++] = x;
        num[0] = num[n++] = 1;
        
        int[][] memo = new int[n][n];
        return helper(num, memo, 0, n - 1);
    }
    private int helper(int[] num, int[][] memo, int start, int end) {
        if(end - start == 1) return 0;
        if(memo[start][end] > 0) return memo[start][end];
        int res = 0;
        for(int i = start + 1; i < end; i++) {
            res = Math.max(res, num[start] * num[i] * num[end] + helper(num, memo, start, i) + helper(num, memo, i, end) );
        }
        memo[start][end] = res;
        return res;
    }


//粗暴解法，time limit exceed
public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
        	boolean[] burst = new boolean[nums.length];
            max = Math.max(max, helper(nums, burst, i));
        }
        return max;
    }
    
    private int helper(int[] nums, boolean[] burst, int start) {
        if(start < 0 || start >= nums.length || burst[start] == true) return 0;
        int before = start -1;
        int after = start + 1;
        burst[start] = true;
        while(before >= 0 && burst[before]) before--;
        while(after <= nums.length - 1 && burst[after]) after++;
        int cur = nums[start] * (before < 0? 1:nums[before]) * (after >= nums.length? 1:nums[after]);
        int left = before < 0? 0:helper(nums, Arrays.copyOf(burst, burst.length), before);
        int right = (start > nums.length - 1)? 0: helper(nums, Arrays.copyOf(burst, burst.length), after);
        return cur + Math.max(left, right);
    }