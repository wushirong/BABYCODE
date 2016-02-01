// O(nk) time complexity, but beats 96.7%  
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 1) return nums;
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int index = 0;
        int resindex = 0;
        for(int i = 0; i <= nums.length - k; i++) {
            if(i == 0 || index == i - 1) {
                max = Integer.MIN_VALUE;
                for(int j = i; j < i + k; j ++) {
                    if(nums[j] > max) index = j;
                    max = Math.max(max, nums[j]);
                }
            }
            else {
                if(nums[i + k - 1] > max) {
                    index = i + k - 1;
                    max = nums[i + k - 1];
                }
            }
            res[resindex++] = max;
        }
        return res;
    }
}

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