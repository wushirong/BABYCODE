/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode newhead = new ListNode(0);
        ListNode add = newhead;
        
        while(head1 != null || head2 != null){
            if(head1 == null) {
                add.next = head2;
                break;
            }
            else if(head2 == null){
                add.next = head1;
                break;
            }
            else if(head1.val < head2.val) {
                add.next = head1;
                add = add.next;
                head1 = head1.next;
            }
            else {
                add.next = head2;
                add = add.next;
                head2 = head2.next;
            }
        }
        return newhead.next;
    }
}