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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        if(root == null) return res;
        helper(sum, res, item, 0, root);
        return res;
    }
    private void helper(int sum, List<List<Integer>> res, List<Integer> item, int cur, TreeNode root) {
        if(root == null) return;
        item.add(root.val);
        cur += root.val;
        if(cur == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        else if(cur != sum && (root.left == null && root.right == null)) return;

        if(root.left != null) {
            helper(sum, res, item, cur, root.left);
            item.remove(item.size() - 1);
        }
        if(root.right != null) {
            helper(sum, res, item, cur, root.right);
            item.remove(item.size() - 1);
        }
    }
}