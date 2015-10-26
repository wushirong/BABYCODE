/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recursion solution
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        return traversal(root, res);
    }
    public List<Integer> traversal(TreeNode root, List<Integer> res) {
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        if(root.left != null) {
            res = traversal(root.left, res);
        }
        res.add(root.val);
        if(root.right != null) {
            res = traversal(root.right, res);
        }
        
        return res;
    }
}

//iterative
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode t = root;
        while(t != null) {
            stack.push(t);
            t = t.left;
        }
        
        while(!stack.isEmpty()) {
            TreeNode tn = stack.pop();
            res.add(tn.val);
            TreeNode rn = tn.right;
            while(rn != null) {
                stack.push(rn);
                rn = rn.left;
            }
        }
        return res;
    }
    
}