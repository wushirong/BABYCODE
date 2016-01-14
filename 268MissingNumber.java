public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int sum = 0;
        for(int i = 0; i < nums.length ; i++) {
            sum = sum + i - nums[i];
        }
        sum += nums.length;
        return sum;
    }
}