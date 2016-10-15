// important to use global definition node. Keep track of list node instead of finding mid node every time would save
// a lot of time. 

public class Solution {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null ) return null;
        if(head.next == null) return new TreeNode(head.val);
        node = head;
        int size = 0;
        ListNode runner = head;
        while(runner != null) {
            runner = runner.next;
            size ++;
        }
        return helper(0, size - 1);
    }
    private TreeNode helper(int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode cur = new TreeNode(node.val);
        node = node.next;
        TreeNode right = helper(mid + 1, end);
        cur.left = left;
        cur.right = right;
        return cur;
    }
}