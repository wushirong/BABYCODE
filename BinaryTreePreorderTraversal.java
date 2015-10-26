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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        return helper(root, res);
        
    }
    public List<Integer> helper(TreeNode root, List<Integer> res) {
        res.add(root.val);
        if(root.left != null) {
            res = helper(root.left, res);
        }
        if(root.right != null) {
            res = helper(root.right, res);
        }
        return res;
    }
}