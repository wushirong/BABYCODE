//using bit calculation
public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return res;
        int result = 0;
        for(int each: nums) {
            result ^= each;
        }
        int lowbit = result & - result;
        //a& lowbit is different from b & lowbit
        for(int each: nums) {
            if((lowbit & each) == 0) res[0] ^= each;
            else res[1] ^= each;
        }
        return res;
    }
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