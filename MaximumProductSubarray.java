public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = nums[0];
        int cur = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int num = max;
            max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(num * nums[i] , nums[i]), min * nums[i]);
            cur = Math.max(max, cur);
        }
        return cur;
    }
}