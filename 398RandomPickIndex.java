public class Solution {
    int[] nums;
    Random r;
    public Solution(int[] nums) {
        this.nums = nums;
        this.r = new Random();
    }
    
    public Integer pick(int target) {
        int i = r.nextInt(nums.length);
        while(nums[i] != target ) {
            i = r.nextInt(nums.length);
        }
        return i;
    }
}