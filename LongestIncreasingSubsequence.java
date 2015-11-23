public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int num = nums.length;
        int[] dp = new int[num];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 1; i < num; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
    return res;
    }
}