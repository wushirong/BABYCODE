public class Solution {
    public int nthUglyNumber(int n) {
        if(n < 4) return n;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(5);
        int ugly = 0;
        for(int i = 2; i<= n ; i++) {
            ugly = pq.poll();
            while(set.contains(ugly)) {
                ugly = pq.poll();
            }
            set.add(ugly);
            pq.add(ugly > Integer.MAX_VALUE / 2? Integer.MAX_VALUE : ugly * 2);
            pq.add(ugly > Integer.MAX_VALUE / 3? Integer.MAX_VALUE : ugly * 3);
            pq.add(ugly > Integer.MAX_VALUE / 5? Integer.MAX_VALUE : ugly * 5);
        }
        return ugly;
    }
    
}