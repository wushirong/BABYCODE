public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 ==  null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next = null;
        boolean carry = false;
        while(l1 != null || l2 != null) {
            int val = l1.val + l2.val;
            if(carry) {
                val++;
                carry = false;
            }
            if(val > 9 ) {
                val %= 10;
                carry  = true;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            if(l1.next == null && l2.next != null) l1 = new ListNode(0);
            else l1 = l1.next;
            if(l2.next == null && l1 != null) l2 = new ListNode(0);
            else l2 = l2.next;
            
        }
        if(carry) cur.next = new ListNode(1);
        return dummy.next;
    }
}