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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode temp = root;
        int leftH = 0;
        int rightH = 0;
        while(temp != null) {
            leftH ++;
            temp = temp.left;
        }
        temp = root;
        while(temp != null) {
            rightH ++;
            temp = temp.right;
            
        }
        if(leftH == rightH) {
            return (1<<leftH) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}