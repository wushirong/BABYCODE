public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while(cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next != cur) {
                pre.next = cur.next;
            }
            else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
//
public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dup = null;
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        dummy.next = head;
        ListNode first = head;
        ListNode second = head.next;
        while(first != null && second != null) {
            if (first.val == second.val) {
                dup = first;
                while (dup != null && first != null && first.val == dup.val) {
                    dummy.next = second;
                    first = second;
                    if (second != null) second = second.next;
                }
            }
            else {
                dummy = first;
                first = second;
                if (second != null) second = second.next;
            }
        }
        return start.next;
    }