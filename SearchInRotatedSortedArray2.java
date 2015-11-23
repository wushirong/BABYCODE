public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) /2;
            if( nums[mid] == target ) return true;
            
            if( nums[mid] > nums[lo] ) {
                if(target < nums[mid] && target >= nums[lo] ) hi = mid - 1;
                else lo = mid + 1;
            }
            else if( nums[mid] < nums[lo] ) {
                if( target > nums[mid] && target <= nums[hi] ) lo = mid + 1;
                else hi = mid - 1;
            }
            else {
               if(nums[lo] == target) return true; 
               else lo++; 
            }
        }
        return false;
       
    }
}