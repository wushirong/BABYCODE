public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while(lo < hi - 1) {
            mid = (lo + hi) / 2;
            if(nums[mid] < nums[hi] ) hi = mid;
            else lo = mid;
        }
        return nums[lo] < nums[hi]? nums[lo]:nums[hi];
    }
}