//usring two pointer to go through two lists. The pointer in the shorter list will be moved to 
//the longer list after get the end of short list. Then continue going until one pointer reach 
// the end of the longer list. If the other pointer also reach null, then there would be no intersaction.
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode walk1 = headA;
        ListNode walk2 = headB;
        while(walk1 != walk2 ) {
            walk1 = walk1 == null ? headB : walk1.next;
            walk2 = walk2 == null ? headA : walk2.next;
        }
        
        return walk1;
    }
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