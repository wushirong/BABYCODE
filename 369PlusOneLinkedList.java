public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastnotnine = dummy;
        ListNode node = head;
        while (node != null) {
            if (node.val != 9) lastnotnine = node;
            node = node.next;
        }
        lastnotnine.val++;
        while(lastnotnine.next != null) {
            lastnotnine = lastnotnine.next;
            lastnotnine.val = 0;
        }
        return dummy.val == 1? dummy: head;
    }

    
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) return head;
        if (helper(head) == 1) {
            ListNode dummy = new ListNode(1);
            dummy.next = head;
            head = dummy;
        }
        return head;
    }
    
    private int helper(ListNode ln) {
        if (ln.next == null || helper(ln.next) == 1) {
            if (ln.val != 9) {
                ln.val = ln.val + 1;
                return 0;
            }
            else {
                ln.val  = 0;
                return 1;
            }
        }
        return 0;
    }
}