//simply using O(n) time to move the val of rest of the list to one step earlier
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        if(node.next == null) node = null;
        
        while(node.next.next != null){
        node.val = node.next.val;
        node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
        
        return;
        
        
    }
}