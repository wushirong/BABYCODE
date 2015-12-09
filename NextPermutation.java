public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int p = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                p = i - 1;
                break;
            }
        }
        if(p < 0) {
            for(int i = 0,j = nums.length - 1; i < j; i++,j--) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        else {
            int i;
           for(i = nums.length - 1; i > p; i--) if(nums[i] > nums[p]) break;
           int temp = nums[i];
           nums[i] = nums[p];
           nums[p] = temp;
           for(int x=p + 1, y=nums.length - 1; x<y;x++,y--) {
               int tem = nums[x];
               nums[x] = nums[y];
               nums[y] = tem;
           }
        }
    }
}