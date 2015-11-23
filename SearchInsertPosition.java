public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        
        int lo = 0;
        int hi = nums.length;
        int index = (lo + hi) / 2;
        while(index > 0) {
            if(nums[index] > target) {
                if(nums[index - 1] < target) return index;
                hi = index;
                index = (lo + hi) / 2;
            }
            else if(nums[index] < target) {
                if(index == nums.length - 1) return nums.length;
                if(nums[index + 1] > target ) return index + 1;
                lo = index;
                index = (lo + hi) / 2;
                
            }
            else return index;
        }
        if(nums[0] >= target) return 0;
        else return 1;
    }
}