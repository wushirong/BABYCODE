//using bit, O(n) time, constant space
public int missingNumber(int[] nums) {
        int res = 0, i = 0;
        for(; i < nums.length; i++) {
            res  = res ^ i ^ nums[i];
        }
        res = res ^ i; // because array doesn't have nums[i], thus this must be handled seperately
        return res;
    }

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