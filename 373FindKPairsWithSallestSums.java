//modified version, similar method as 378
static class Tuple implements Comparable<Tuple> {
        int a;
        int b;
        int val;
        public Tuple (int a, int b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }
        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        for (int i = 0; i < nums2.length; i++) pq.offer(new Tuple(0, i, nums1[0] + nums2[i]));
        for (int i = 0; i < Math.min(k, nums1.length * nums2.length); i++) {
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.a], nums2[t.b]});
            if (t.a == nums1.length-1) continue;
            pq.offer(new Tuple(t.a+1, t.b, nums1[t.a+1] + nums2[t.b]));
        }
        return res;
    }
///////////////////////

public class Solution {
    static class Tuple implements Comparable<Tuple> {
        int a;
        int b;
        int val;
        public Tuple (int a, int b) {
            this.a = a;
            this.b = b;
            this.val = a+b;
        }
        @Override
        public int compareTo(Tuple that) {
            return that.val - this.val;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.offer(new Tuple(nums1[i], nums2[j]));
                if (pq.size() > k) pq.poll();
            }
        }
        List<int[]> res = new ArrayList<>();
        for (Tuple t: pq) {
            res.add(new int[]{t.a, t.b});
        }
        return res;
    }
}