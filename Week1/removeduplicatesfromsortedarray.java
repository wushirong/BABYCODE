public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int resI=0;
        int cur=1;
        
           for(cur=1;cur<nums.length;cur++){
               if(nums[resI]!=nums[cur]){
                   resI++;
                   nums[resI]=nums[cur];
               }
           }
           resI+=1;
        return resI;
    }
}