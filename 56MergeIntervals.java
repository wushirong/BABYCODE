public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        
        
        Interval prev = intervals.get(0);
        for(Interval cur: intervals) {
            int start = Math.min(prev.start, cur.start);
            int end = Math.max(prev.end, cur.end);
            if(cur.start > prev.end) {
                res.add(prev);
                prev = cur;
            }
            else {
                Interval merge = new Interval(start, end);
                prev = merge;
            }
        }
        res.add(prev);
        return res;
    }
}