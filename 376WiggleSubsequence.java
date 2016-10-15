public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        if(nums.length == 1) return 1;
        int max = 1;
        boolean increase = nums[1] > nums[0];
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(increase) {
                if(nums[i] > prev) {
                    increase = !increase;
                    max++;
                }
            }
            else {
                if(nums[i] < prev) {
                    increase = !increase;
                    max++;
                }
            }
            prev = nums[i];
        }
        return max;
    }