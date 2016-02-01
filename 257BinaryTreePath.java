//clean version, O(n) time and space, DFS
public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        helper(root, res, "");
        return res;
    }
    private void helper(TreeNode root, List<String> list, String path) {
        if(root.left == null && root.right == null) list.add(path + root.val);
        if(root.left != null) helper(root.left, list, path + root.val + "->");
        if(root.right != null) helper(root.right, list, path + root.val + "->");
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        if(root == null) return res;
        String path = "";
        return helper(root, res, path);
    }
    public List<String> helper(TreeNode root, List<String> res, String path) {
        path += root.val;
        if(root.left == null && root.right == null) {
            res.add(path);
            return res;
        }
        path += "->";
        if(root.left != null) {
            res = helper(root.left, res, path);
        }
        if(root.right != null) {
            res = helper(root.right, res, path);
        }
        return res;
    }
}