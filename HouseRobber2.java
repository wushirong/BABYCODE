public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    private int helper(int[] nums, int start, int end) {
        int length = end -start + 1;
        int[] res = new int[length];
        res[1] = Math.max(nums[start], nums[start+1]);
        res[0] = nums[start];
        for(int i = 2; i < length; i++) {
            res[i] = Math.max(nums[start+i] + res[i-2], res[i-1]);
        }
        return res[length-1];
    }
}