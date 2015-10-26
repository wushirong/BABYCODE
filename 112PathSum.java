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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null || (sum == 0 && root.val != 0)) return false;
        int count = 0;
        return pathSum(root, sum, count);
        
    }
    
    public boolean pathSum(TreeNode root, int sum, int num) {
        if(root == null) return false;
        num += root.val;
        if(root.left == null && root.right == null && sum == num) return true;
        return pathSum(root.left, sum, num) || pathSum(root.right, sum, num);
    }
}