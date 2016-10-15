//not self wrote
public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int small = Integer.MAX_VALUE; 
        int large = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= small) small = nums[i];
            else if(nums[i] <= large) large = nums[i];
            else return true;
        }
        return false;
    }