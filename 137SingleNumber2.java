public int singleNumber(int[] nums) {
         if(nums == null || nums.length == 0) return 0;
         int[] bit = new int[32];
         for(int i = 0; i < 32; i++) {
             for(int j = 0; j < nums.length; j++) {
                 int cur = nums[j];
                 bit[i] += (cur>>i)&1;
             }
         }
         int res = 0;
         for(int i = 31; i >= 0; i--) {
             res = res * 2 + bit[i]%3;
         }
         return res;
    }