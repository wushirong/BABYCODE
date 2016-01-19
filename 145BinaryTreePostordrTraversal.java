//DFT recursively goes into the tree and exam every node
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

//can also be solved by using stack
public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.add(root);
        while(! stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
            
        }
        return res;
    }