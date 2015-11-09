/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ArrayList<Integer> item = new ArrayList<Integer>();
        ListNode node = head;
        while(node != null) {
            item.add(node.val);
            node = node.next;
        }
        TreeNode res = null;
        return helper(res, item, 0, item.size() - 1);
        
    }
    private TreeNode helper(TreeNode cur, ArrayList<Integer> item, int low, int high) {
        if(low > high) return null;
        int mid = (low + high)/2;
        cur = new TreeNode(item.get(mid));

        cur.left = helper(cur.left, item, low, mid - 1);
        cur.right = helper(cur.right, item, mid + 1, high);
        return cur;
    }
}