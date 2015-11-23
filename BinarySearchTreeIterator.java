/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private LinkedList<Integer> items;
    
    public BSTIterator(TreeNode root) {
        items = new LinkedList<Integer>();
        helper(root);
    }

    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        items.offer(root.val);
        helper(root.right);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !items.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return items.poll();
        
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */