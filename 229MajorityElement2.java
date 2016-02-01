//O(n) time, constant space, go through the array and procolate 2 possible candidate, 
//then check whether the two candidate is qualified.
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        int l = nums.length;
        if(nums == null || nums.length == 0) return res;
        else if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int[] num = {nums[0], nums[1]};
        int[] count = {0, 0};
        for(int i = 0; i < l; i++) {
            
            if(nums[i] == num[0]) count[0]++;
            else if(nums[i] == num[1]) count[1]++;
            
            else if(count[0] == 0) {
                count[0] = 1;
                num[0] = nums[i];
            }
            else if(count[1] == 0) {
                count[1] = 1;
                num[1] = nums[i];
            }
            else {
                count[0]--;
                count[1]--;
            }
        }
        //check whether numbers in num[] is qualified
        int time1 = 0;
        int time2 = 0;
        for(int i = 0; i < l; i++) {
            if(nums[i] == num[0]) time1++;
            if(nums[i] == num[1]) time2++;
        }
        if(time1 > l/3) res.add(num[0]);
        if(time2 > l/3 && num[1] != num[0]) res.add(num[1]);
        return res;
    }
}