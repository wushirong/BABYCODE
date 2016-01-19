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

//more clean version, use constant space and linear time. Usint two pointers walking on the list, and they would encounter if there is a cycle
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner) return true;
        }
        return false;
    }
}