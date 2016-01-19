//使用hashmap， 但是有两次便利，用时更多
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

//clean version of hashmap solution
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[1] = i + 1;
                res[0] = map.get(target - nums[i]) + 1;
            }
            else map.put(nums[i], i);
        }
        return res;
    }
}