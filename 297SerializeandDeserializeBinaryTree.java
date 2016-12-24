//for string comparasion, using .equals() is very very very important!!!!
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                res.append("N").append(',');
            }
            else{
                res.append(cur.val).append(',');
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = null;
        int index = 0;
        if(data.length() == 0) return root;
        String[] single = data.split(",");
        root = new TreeNode(Integer.parseInt(single[0]));
        queue.offer(root);
        
        
        while(! queue.isEmpty() && index < single.length) {
            TreeNode cur = queue.poll();
            index++;
            if(index < single.l ength && !single[index].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(single[index]));
                queue.offer(left);
                cur.left = left;
            }
            else cur.left = null;
            index ++;
            if(index < single.length && !single[index].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(single[index]));
                queue.offer(right);
                cur.right = right;
            }
            else cur.right = null;
        }
        return root;
    }
}