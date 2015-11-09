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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        res.add(root.val);
        helper(root, res, 1);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int depth) {
        if(root.left == null && root.right == null){
            return;
        }
        if(root.right!= null ) {
            if(depth >= res.size()) res.add(root.right.val);
            helper(root.right, res, depth + 1);
        }
        else if(root.left != null) {
            if(depth >= res.size() ) res.add(root.left.val);
            helper(root.left, res, depth + 1);
        }
        if(root.left != null) {
            if(depth > res.size() ) res.add(root.right.val);
            helper(root.left, res, depth + 1);
        }
        
    }
}