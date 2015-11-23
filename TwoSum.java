public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0 ) return null;
        int[] res = new int[2];
        HashMap map = new HashMap();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(map.containsKey(target - nums[i])) {
                int second = (int)map.get(target - nums[i]);
                if(second > i) {
                    res[0] = i + 1;
                    res[1] = second + 1;
                    return res;
                }

            }
        }
        return res;
    }
}