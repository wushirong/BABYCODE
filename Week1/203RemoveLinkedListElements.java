/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            }
            else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}