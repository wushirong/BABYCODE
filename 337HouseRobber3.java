public class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] num = helper(root);
        return Math.max(num[0], num[1] );
    }
    
    private int[] helper(TreeNode tn) {
        if (tn == null) return new int[2];
        int[] left = helper(tn.left);
        int[] right = helper(tn.right);
        int[] res = new int[2];
        res[0] = tn.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1] ) + Math.max(right[0], right[1] );
        return res;
    }
}