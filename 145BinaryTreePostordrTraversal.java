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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        return helper(root, res);
    }
    public List<Integer> helper(TreeNode root, List<Integer> res) {
        
        if(root.left != null) helper(root.left, res);
        if(root.right != null) helper(root.right, res);
        res.add(root.val);
        return res;
    }
}