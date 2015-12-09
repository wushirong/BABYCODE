public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        head = head.next;
        ListNode post;
        
        while(cur != null && cur.next != null) {
            post = cur.next.next;
            swap(pre, post, cur, cur.next);
            pre = cur;
            cur = post;
        }
        return head;
    }
    private void swap(ListNode pre, ListNode post, ListNode node1, ListNode node2) {
        pre.next = node2;
        node2.next = node1;
        node1.next = post;
    }
}