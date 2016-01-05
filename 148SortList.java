/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 用两个指针，一个走一步，一个走两步，快速找到中点
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode end = head.next.next;
        ListNode preEnd = head;
        while(end != null && end.next != null) {
            preEnd = preEnd.next;
            end = end.next.next;
        }
        ListNode tn = sortList(preEnd.next);
        preEnd.next = null;
        return merge(sortList(head), tn);
    }
    
    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummy;
        while(p != null && q != null) {
            if(p.val < q.val) {
                head.next = p;
                p = p.next;
            }
            else {
                head.next = q;
                q = q.next;
            }
            head = head.next;
        }
        if(p != null) head.next = p;
        if(q != null) head.next = q;
        return dummy.next;
    }
}