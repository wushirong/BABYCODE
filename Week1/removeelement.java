public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }
        
        int length=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                nums[i]=nums[length-1];
                nums[length-1]=-1;
                length--;
                i--;
            }
            if(nums.length<1)
            break;
        }
      return length;  
    }
}