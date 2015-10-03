public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        Arrays.sort(nums);
        int res=nums[nums.length/2];
        return res;
    }
}