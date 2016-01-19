//从下往上recursive，一旦发现不是balance就返回-1，最后判断返回值是否小于0
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
    public boolean isBalanced(TreeNode root) {
        
        return helper(root) >= 0;
    }
    public int helper(TreeNode tn) {
        if(tn == null) return 0;
        int left = helper(tn.left);
        int right = helper(tn.right);
        if(Math.abs(left - right) > 1) return -1;
        if(left < 0 || right < 0) return -1;
        return Math.max(left, right) + 1;
    }
}