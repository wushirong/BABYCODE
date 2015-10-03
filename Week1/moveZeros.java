public class Solution {
    public void moveZeroes(int[] nums) {
        int cur=0;
        if(nums==null||nums.length==0){
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[cur++]=nums[i];
            }
        }
        for(int j=cur;j<nums.length;j++){
            nums[j]=0;
        }
        
    }
}