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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        res.add(new ArrayList<Integer>());
        return helper(root, res, 0);
    }
    public List<List<Integer>> helper(TreeNode tn, List<List<Integer>> res, int index) {
        if(tn == null) return res;
        List<Integer> subList = res.get(index);
        subList.add(tn.val);
        index++;
        if(res.size() < index+1 && (tn.left != null || tn.right != null)) res.add(new ArrayList<Integer>());
        helper(tn.left, res, index);
        helper(tn.right, res, index);

        return res;
    }
}