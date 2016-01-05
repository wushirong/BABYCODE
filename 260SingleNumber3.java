//using linear time& space
public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null) return null;
        HashSet<Integer> set = new HashSet<Integer>();
        int[] res = new int[2];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        for(int item : set) {
            res[index] = item;
            index ++;
        }
        return res;
    }
}