/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        
        TreeNode res = null;
        return helper(res, nums, 0, nums.length - 1);
        
    }
    private TreeNode helper(TreeNode cur, int[] item, int low, int high) {
        if(low > high) return null;
        int mid = (low + high)/2;
        cur = new TreeNode(item[mid]);

        cur.left = helper(cur.left, item, low, mid - 1);
        cur.right = helper(cur.right, item, mid + 1, high);
        return cur;
    }
    
}