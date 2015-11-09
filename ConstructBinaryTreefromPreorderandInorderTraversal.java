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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length - 1, 0, preorder.length - 1, map);
        
    }
    private TreeNode helper(int[] preorder, int[] inorder, int inL, int inR, int preL, int preR, HashMap<Integer, Integer> map) {
        if(preL > preR || inL > inR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int index = map.get(root.val);
        root.left = helper(preorder, inorder, inL, index - 1, preL +1, preL + index - inL, map);
        root.right = helper(preorder, inorder, index + 1, inR, preL + index -inL + 1, preR, map);
        return root;
    }
}