/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode pre = head;
        ListNode succ = head;
        while(succ.next != null && succ.next.next != null) {
            succ = succ.next.next;
            pre = pre.next;
        }
        succ = reverse(pre.next);
        pre = head;
        while(succ != null){
            if(succ.val != pre.val) return false;
            succ = succ.next;
            pre = pre.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode post = cur.next;
        while(cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
        
    }
}