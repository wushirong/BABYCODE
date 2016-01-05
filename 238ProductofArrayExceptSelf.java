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