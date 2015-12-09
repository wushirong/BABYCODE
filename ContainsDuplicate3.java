//using treeset
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0) return false;
        TreeSet<Integer> values = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            Integer floor = values.floor(nums[i] + t);
            Integer ceiling = values.ceiling(nums[i] - t);
            if((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i]) ) return true;
            values.add(nums[i]);
            if(i >= k) values.remove(nums[i - k]);
        }
        return false;
    }

}