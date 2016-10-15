public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        boolean up = false;
        ListNode cur = root;
        while(l1 != null || l2 != null || up) {
            int val = (l1 == null? 0:l1.val) + (l2 == null? 0:l2.val) ;
            if(up) {
                val++;
                up = false;
            }
            if(val > 9) {
                up = true;
                val %= 10;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }