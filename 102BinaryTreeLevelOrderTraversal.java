//用两个 queue 分别记录node 和 level，然后对应存储到hashmap中，当处理queue中的node时，分别pop出node和其对应level，去map中
//时候已经有对应level的list，若有则将新value加在后面， 没有则建立新的（key, value）
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