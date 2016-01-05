/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//逐个将index = m的node往后退，并将接下来的一个node移至substring的第一个
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || n <= m) return head;
        int index = 0;
        ListNode dummy = new ListNode(0);
        ListNode walker = null;
        ListNode pre = dummy;
        ListNode then = null;
        dummy.next = head;
        for(int i = 0; i< m - 1; i++) pre = pre.next;
        walker = pre.next;
        then = walker.next;
        for(int i = 0; i < n - m; i++) {
            walker.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = walker.next;
        }
        
        return dummy.next;
    }
    
    
}