public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int num:nums) {
            sum += num;
            res = sum > res? sum:res;
            if(sum < 0) sum = 0;
        }
        return res;
    }
}