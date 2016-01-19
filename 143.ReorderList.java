//ugly version  很容易形成死循环或者无限循环，导致runtime error，尤其是指针重复使用很容易导致混乱
//first reverse the second half of the stream, and remember to break the connection in the mid. Otherwise there would be dead lock.
//Thencombine the reversed list into the origin half list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode walker = head;
        ListNode runner = head;
        ListNode head1 = head;
        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head2 = walker.next;
        walker.next = null;
        walker = head2;
        runner = head2.next;
        walker.next = null;
        ListNode m = null;
        while(runner != null) {
            m = runner.next;
            runner.next = walker;
            walker = runner;
            runner = m;
        }
        head2 = walker;
        ListNode n = null;
        while(head2 != null) {
            m = head1.next;
            n = head2.next;
            head1.next = head2;
            head2.next = m;
            head1 = m;
            head2 = n;
        }
    }
}

// a little bit modification
public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode walker = head;
        ListNode runner = head;
        ListNode head1 = head;
        ListNode head2 = null;
        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode mid = walker;
        head2 = walker;
        walker = head2.next;
        head2.next = null;
        ListNode next = null;
        while(walker != null) {
            next = walker.next;
            walker.next = head2;
            head2 = walker;
            walker = next;
        }
        
        while(head2 != mid) {
            walker = head1.next;
            runner = head2.next;
            head1.next = head2;
            head2.next = walker;
            head2 = runner;
            head1 = walker;
        }
    }