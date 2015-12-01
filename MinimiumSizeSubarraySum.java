public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int lo = 0;
        int sum = 0;
        int length = nums.length;
        int allsum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            allsum += nums[i];
            while(sum >= s) {
                length = length > i - lo + 1? i - lo + 1:length;
                sum -= nums[lo++];
            }
        }
        return allsum < s? 0:length;
    }

}