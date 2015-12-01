/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode newhead = head;
        ListNode tail = head.next;
        ListNode cur = head;
        int count = 1;
        while(cur.next != null) {
            cur = cur.next;
            count ++;
        }
        k = k % count;
        tail = cur;
        cur = head;
        tail.next = head;
        for(int i = 0; i < (count - k - 1); i++) {
            cur = cur.next;
        }
        newhead = cur.next;
        cur.next = null;
        return newhead;
    }
}