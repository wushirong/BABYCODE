/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode small = dummy;
        ListNode cur = dummy;
        while(cur != null && cur.next != null) {
            if(cur.next.val < x) {
                if(small != cur) {
                    ListNode node = cur.next.next;
                    cur.next.next = small.next;
                    small.next = cur.next;
                    cur.next = node;
                }
                small = small.next;
                if(small == cur.next) cur = cur.next;
                
            }
            else cur = cur.next;
        }
        return dummy.next;
    }
}