public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums==null){
            return;
        }
        int[] res=new int[nums.length];
        int j=k%nums.length;
        for(int i=0;i<nums.length;i++){
            res[j]=nums[i];
            j=(j+1)%nums.length;
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }
}