/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        LinkedList<TreeLinkNode> item = new LinkedList<TreeLinkNode>();
        item.add(root);
        helper(item);
        
        return;
    }
    private void helper(LinkedList<TreeLinkNode> item) {
        if(item == null || item.size() == 0) return;
        int size = item.size();
        for(int i = 0; i < size; i++) {
            TreeLinkNode temp = item.poll();
            if(! item.isEmpty() && (i < size - 1)) temp.next = item.peek();
            else temp.next = null;
            if(temp.left != null) item.offer(temp.left);
            if(temp.right != null) item.offer(temp.right);
        }
        helper(item);
    }
}