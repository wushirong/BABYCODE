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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        LinkedList<TreeNode> tn = new LinkedList<TreeNode>();
        tn.offer(root);
        int last = 1;
        int cur = 0;
        ArrayList level = new ArrayList();
        while(! tn.isEmpty()) {
            TreeNode t = tn.poll();
            level.add(t.val);
            last--;
            if(t.left != null) {
                tn.offer(t.left);
                cur++;
            }
            if(t.right != null) {
                tn.offer(t.right);
                cur++;
            }
            if(last == 0) {
                res.add(level);
                last = cur;
                cur = 0;
                level = new ArrayList(); 
            }
        }
        Collections.reverse(res);
        return res;
    }
}