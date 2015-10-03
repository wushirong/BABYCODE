/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==  null) {
            return null;
        }
        
        ListNode dummy = new ListNode(head.val);
        dummy.next = head;
        head = dummy;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        
        while(cur != null) {
            if(pre.val == cur.val) {
                if (cur.next != null) {
                    pre.next = cur.next;
                    cur.next = null;
                    cur = pre.next;
                }
                else {
                    pre.next = null;
                    break;
                }
            }
            else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }
}