public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        return prev;
    }