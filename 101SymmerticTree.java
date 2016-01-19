//时间复杂度O(n) 空间复杂度O(n) 利用stack对所有node进行遍历，对比每个node的left&right&self value
//可以尝试使用recursive替换

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmertic(root.left, root.right);
    }
    
    private boolean symmertic(TreeNode leftroot, TreeNode rightroot) {
        if(leftroot == null && rightroot == null) return true;
        if((leftroot != null && rightroot == null) || (rightroot !=null && leftroot == null) ||(leftroot.val != rightroot.val)) return false;
        else{
            return symmertic(leftroot.left, rightroot.right) && symmertic(leftroot.right, rightroot.left);
        }
    }
}

//solution 2
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        LinkedList<TreeNode> l1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> l2 = new LinkedList<TreeNode>();
        
        l1.offer(root.left);
        l2.offer(root.right);
        while(l1.size() > 0 && l2.size() > 0) {
            TreeNode t1 = l1.poll();
            TreeNode t2 = l2.poll();
            if(t1.left == null && t2.right != null ||
               t1.left != null && t2.right == null ||
               t1.right == null && t2.left != null ||
               t1.right != null && t2.left == null ||
               t1.val != t2.val )
               return false;
            if(t1.left != null && t2.right != null){
                l1.offer(t1.left);
                l2.offer(t2.right);
            }
            if(t1.right != null && t2.left != null){
                l1.offer(t1.right);
                l2.offer(t2.left);
            }
        }
        return true;
    }
    
    
}