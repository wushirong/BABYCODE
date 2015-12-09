public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        HashSet<ListNode> set = new HashSet<ListNode>();
        
        ListNode walker = head;
        while(walker != null) {
            if(!set.add(walker)) return true;
            walker = walker.next;
        }
        return false;
    }
}