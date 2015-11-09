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
    // public int sumNumbers(TreeNode root) {
    //     StringBuilder res = new StringBuilder();
    //     int sum = 0;
    //     if(root == null) return sum;
    //     helper(root, sum, res);
    //     return sum;
    // }
    // private void helper(TreeNode root, int sum, StringBuilder res) {
    //     if(root == null) return;
    //     else if(root.left == null && root.right == null) {
    //         res.append(root.val);
    //         sum += Integer.parseInt(res.toString());
    //         return;
    //     }
        
    //     res.append(root.val);
    //     helper(root.left, sum, res);
    //     helper(root.right, sum, res);
    //     res.deleteCharAt(res.length() - 1);
    //     return;
    // }
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int sum) {
         if(root == null) return 0;
         if(root.left == null && root.right == null) return sum * 10 + root.val;
         return helper(root.left, 10 * sum + root.val) + helper(root.right, 10 * sum + root.val);
    }
}