/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // find a suitable place between runner & runner.next, then insert the walker node into the place
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        
        ListNode runner = dummy;
        ListNode walker = head;
        ListNode next;
        while(walker != null) {
            next = walker.next;
            while(runner.next != null && runner.next.val <= walker.val) runner = runner.next;
            walker.next = runner.next;
            runner.next = walker;
            runner = dummy;
            walker = next;
        }
        return dummy.next;
    }
}