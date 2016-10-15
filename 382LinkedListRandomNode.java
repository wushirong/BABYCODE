public class Solution {
    ListNode head;
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 1;
        ListNode cur = this.head;
        ListNode res = this.head;
        while(cur != null) {
            if (random.nextInt(count) == 0) {
                res = cur;
            }
            count++;
            cur = cur.next;
        }
        return res.val;
    }
} 