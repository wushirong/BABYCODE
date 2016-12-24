public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        while(l1 != null) {
            stack1.add(l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.add(l2);
            l2 = l2.next;
        }
        int up = 0;
        ListNode dummy = new ListNode(0);
        Stack<ListNode> longerStack = stack1.size() > stack2.size()? stack1: stack2;
        while (!stack1.isEmpty() || !stack2.isEmpty() ||  up > 0) {
            int val = (stack1.isEmpty()?0:stack1.pop().val) + (stack2.isEmpty()?0:stack2.pop().val) + up;
            ListNode cur = new ListNode(val%10);
            up = val/10;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }