//uesing deque to make things easier
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int l = nums.length;
        int[] res = new int[l - k + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        int index = 0;
        for(index = 0; index < k; index++) {
            while(! deque.isEmpty() && nums[deque.getLast()] < nums[index]) deque.removeLast();
            deque.addLast(index);
        }
        
        for(;index < l; index++) {
            res[index - k] = nums[deque.getFirst()];
            while(! deque.isEmpty() && deque.getFirst() <= index -k) deque.removeFirst();
            while(! deque.isEmpty() && nums[deque.getLast()] <= nums[index]) deque.removeLast();
            deque.addLast(index);
        }
        res[index - k] = nums[deque.getFirst()];
        return res;
    }
}