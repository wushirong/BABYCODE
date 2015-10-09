/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode record1 = headA;
        ListNode record2 = headB;
        while(record1 != null && record2 != null) {
            if(record1.val == record2.val) return record1;
            else if(record1.val < record2.val) record1 = record1.next;
            else record2 = record2.next;
        }
       return null;
    }
}