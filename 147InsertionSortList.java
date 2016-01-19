// basic idea of insertion sort, using dummy node to helper avoid corner case
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//using n^2 time and constant space, go through every node and find its suitable place .
//put it into the right place and go on to next node
 // find a suitable place between runner & runner.next, then insert the walker node into the place
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        //dummy.next = head;   this sentence can cause run time error
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