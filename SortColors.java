public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            switch(nums[i]) {
                case 0:
                    count1++;
                    break;
                case 1:
                    count2++;
                    break;
                case 2:
                    count3++;
                    break;
            }
        }
        for(int i = 0; i < count1; i++) {
            nums[i] = 0;
        }
        for(int i = count1; i < count1 + count2; i++) {
            nums[i] = 1;
        }
        for(int i = count1 + count2; i < count3 + count1 + count2; i++) {
            nums[i] = 2;
        }
    }
}