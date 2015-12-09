public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 0;
        boolean dup = false;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[index] && !dup) {
                nums[++index] = nums[i];
                dup = true;
            }
            else if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
                dup = false;
            }
        }
        return index + 1;
    }
}