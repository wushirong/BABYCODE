/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        
        int count = 1;
        ListNode cur = head;
        ListNode rem = head;
        
        while(cur.next != null){
            cur=cur.next;
            count++;
        }
        count = count - n;
        if(count == 0) {
            head = head.next;
            return head;
        }
        for (int i = 0; i < count-1; i++) {
            rem=rem.next;
        }
        if(rem.next.next == null){
            rem.next = null;
        }
        else{
            rem.next = rem.next.next;
        cur.next = null;
        }
        return head;
    }
}