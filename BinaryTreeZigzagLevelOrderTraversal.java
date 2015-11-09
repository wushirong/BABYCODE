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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int level = 0;
        if(root == null) return res;
        stack.push(root);
        helper(res, 0, stack);
        return res;
    }
    private void helper(List<List<Integer>> res, int level, LinkedList<TreeNode> stack) {
        if(stack.isEmpty()) return;
        LinkedList<TreeNode> newStack = new LinkedList<TreeNode>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        while(! stack.isEmpty()) {
            TreeNode cur = stack.pop();
            item.add(cur.val);
            if(level % 2 == 0) {
                if(cur.left != null) newStack.push(cur.left);
                if(cur.right != null) newStack.push(cur.right);
            }
            else {
                if(cur.right != null) newStack.push(cur.right);
                if(cur.left != null) newStack.push(cur.left);
            }
        }
        res.add(item);
        helper(res, level + 1, newStack);
    }
}