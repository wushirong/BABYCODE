//another method using priority queue, o(n) time and space
public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode ln1, ListNode ln2) {
                if(ln1.val > ln2.val) return 1;
                else if(ln1.val == ln2.val) return 0;
                else return -1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(ListNode each: lists) {
            if(each != null) queue.offer(each);
        }
        while(! queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            
            if(tail.next != null) queue.offer(tail.next);
        }
        return dummy.next;
    }

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int l = lists.length;
        if(l == 1) return lists[0];
        ListNode[] res = new ListNode[(l + 1) / 2];
        for(int i = 0; i < res.length - 1; i++) {
            res[i] = helper(lists[2 * i], lists[2 * i + 1]);
        }
        res[res.length - 1] = lists.length % 2 == 0? helper(lists[l - 2], lists[l - 1]) : lists[l - 1];
        return mergeKLists(res);
    }
    private ListNode helper(ListNode ln1, ListNode ln2) {
        ListNode merge = new ListNode(0);
        ListNode dummy = merge;
        while(ln1 != null || ln2 != null) {
            if(ln1 != null && (ln2 == null || ln1.val < ln2.val)) {
                merge.next = ln1;
                merge = merge.next;
                ln1 = ln1.next;
            }
            else {
                merge.next = ln2;
                merge = merge.next;
                ln2 = ln2.next;
            }
        }
        return dummy.next;
    }
}