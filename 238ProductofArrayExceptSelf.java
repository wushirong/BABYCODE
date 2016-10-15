public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int sum = 1;
        int hasZero = 0;
        for (int num: nums) {
            if (num != 0) sum *= num;
            else hasZero++;
        }
        if (hasZero > 1) sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = sum;
            else {
                if (hasZero > 0) nums[i] = 0;
                else nums[i] = sum / nums[i];
            }
        }
        return nums;
    }

//revised version, no extra space used, O(n) time complexity
public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int l = nums.length;
        int[] res = new int[l];
        res[0] = 1;
        for(int i = 1; i < l; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int former = 1;
        for(int i = l - 1; i >= 0; i--) {
            res[i] *= former;
            former *= nums[i];
        }
        return res;
    }


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null) return nums;
        int length = nums.length;
        int[] preorder = new int[length];
        preorder[0] = 1;
        int[] postorder = new int[length];
        postorder[0] = 1;
        int[] res = new int[length];
        for(int i = 1; i < length; i++) {
            preorder[i] = preorder[i-1] * nums[i - 1];
            postorder[i] = postorder[i-1] * nums[length - i];
        }
        for(int i = 0; i < length; i++) {
            res[i] = preorder[i] * postorder[length - 1 - i];
        }
        return res;
    }
}