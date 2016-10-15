public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int lo, int hi) {
        int prevR = 0, prevNR = 0, rob = 0, notrob = 0;
        for(int i = lo; i <= hi; i++) {
            rob = prevNR + nums[i];
            notrob = Math.max(prevNR, prevR);
            prevNR = notrob;
            prevR = rob;
        }
        return Math.max(rob, notrob);
    }