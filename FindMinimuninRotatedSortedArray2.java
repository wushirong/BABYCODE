public class Solution {
    public int findMin(int[] nums) {
        if(nums ==  null || nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        int min = nums[0];
    
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(nums[mid] < nums[lo]) {
                min = Math.min(min, nums[mid]);
                hi = mid -1;
            }
            else if(nums[mid] > nums[lo] ) {
                min = Math.min(min, nums[lo]);
                lo = mid + 1;}
            else {
                min = Math.min(min, nums[lo]);
                lo++;
            }
        }
        return min;
    }
}