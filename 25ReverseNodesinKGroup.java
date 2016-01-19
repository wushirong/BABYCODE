// using recursive to avoid dead lock or endless loop problem. Otherwise, it is very esay to fall into 
// a circle without notice.
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;
        ListNode cur = head;
        int count = 0;
        for(; count < k; count++) {
            if(cur == null) return head;
            else cur = cur.next;
        }
        cur = reverseKGroup(cur, k);
        while(count-- > 0) {
            ListNode next = head.next;
            head.next = cur;
            cur =  head;
            head = next;
        }
        head = cur;
        return head;
    }
}