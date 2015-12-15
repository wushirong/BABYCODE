public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return res;
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1] ) continue;
            for(int j = i+1; j < nums.length - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1] ) continue;
                int  k = j + 1, l = nums.length - 1;
                while(k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while(k < l && nums[k] == nums[k+1]) k++;
                        while(k < l && nums[l] == nums[l-1]) l--;
                        k++;
                        l--;
                    }
                    else if(sum > target) l--;
                    else k++;
                }
                
                
            }
        }
        return res;
    }
    
}