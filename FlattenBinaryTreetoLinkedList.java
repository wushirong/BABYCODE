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
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> item = new LinkedList<TreeNode>();
        helper(item, root);
        root = item.poll();
        while(! item.isEmpty()) {
            root.right = item.poll();
            root.left = null;
            root = root.right;
        }
    }
    private void helper(LinkedList<TreeNode> item, TreeNode root) {
        if(root == null) return;
        else if(root.left == null && root.right == null) {
            item.offer(root);
            return;
        }
        
        item.offer(root);
        if(root.left != null) helper(item, root.left);
        if(root.right != null) helper(item, root.right);
        
    }
}