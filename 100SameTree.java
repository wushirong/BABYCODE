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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null || p.val != q.val) return false;
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(p);
        q2.offer(q);
        while(q1.size() > 0 && q2.size() > 0) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            
            if(t1.left != null && t2.left == null ||
               t1.left == null && t2.left != null ||
               t1.right == null && t2.right != null ||
               t1.right == null && t2.right != null ||
               t1.val != t2.val)
               return false;
            if(t1.left != null && t2.left != null) {
                q1.offer(t1.left);
                q2.offer(t2.left);
            }
            if(t1.right != null && t2.right != null) {
                q1.offer(t1.right);
                q2.offer(t2.right);
            }
        }
        return true;
    }
}