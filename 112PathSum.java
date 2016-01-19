//用DFS进行便利， 时间复杂度O(n), 空间复杂度O(log n)


//简化后的DFS versioin
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
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