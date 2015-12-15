public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;
        int res = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1, k = nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return sum;
                else if(sum > target) {
                    if(min > sum-target) {
                        res = sum;
                        min = sum - target;
                    }
                    k--;
                }
                else {
                    if(min > target - sum) {
                        res = sum;
                        min = target - sum;
                    }
                    j++;
                }
            }
        }
        return res;
    }
}