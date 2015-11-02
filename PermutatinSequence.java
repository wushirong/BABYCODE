public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        int[] nums = new int[10];
        int fact = 1;
        int index = 0;
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
            fact *= (i + 1);
        }
        k--;
        for(int i = 0; i < n; i++) {
            fact = fact/(n - i);
            index = k / fact;
            res.append(nums[index]);
            for(int j = index; j < n; j++) nums[j] = nums[j+1];
            k %= fact;
        }
        return res.toString();
    }
    
}