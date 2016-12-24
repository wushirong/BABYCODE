public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode copy = new RandomListNode(head.label);
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = copy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode rn = head;
        while (rn.next != null) {
             RandomListNode next = new RandomListNode(rn.next.label);
             copy.next = next;
             copy = copy.next;
             rn = rn.next;
             map.put(rn, copy);
        }
        rn = head;
        copy = dummy.next;
        while (rn != null) {
            if (rn.random != null) {
                if (!map.containsKey(rn.random)) copy.random = new RandomListNode(rn.random.label);
                else copy.random = map.get(rn.random);
            }
            rn = rn.next;
            copy = copy.next;
        }
        return dummy.next;
    }