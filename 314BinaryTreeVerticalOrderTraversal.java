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
    private int min = 0, max = 0;
  
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        q.add(root);
        level.add(0);
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int value = level.poll();
            if(!map.containsKey(value)) {
                List<Integer> list = new LinkedList<Integer>();
                list.add(node.val);
                map.put(value, list);
            }
            else map.get(value).add(node.val);
            if(node.left != null) {
                q.add(node.left);
                level.add(value-1);
            }
            if(node.right != null) {
                q.add(node.right);
                level.add(value+1);
            }
        }
        for(int index: map.keySet()) {
            min = Math.min(min, index);
            max = Math.max(max, index);
        }
        for(int i = min; i <= max; i++) {
            if(map.containsKey(i)) res.add(map.get(i));
        }
        return res;
    }
}