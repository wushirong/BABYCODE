public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;        // important, if use return a.start < b.start? -1:1; directly, would have illegal compare error, add a if (a.start == b.start) return 0; can solve
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        for (int i = 0; i < intervals.size(); i++) {
            int end = intervals.get(i).end;
            while (i+1 < intervals.size() && intervals.get(i+1).start <= end) {
                end = Math.max(intervals.get(++i).end, end);
            }
            res.add(new Interval(start, end));
            if (i < intervals.size()-1) start = intervals.get(i+1).start;
        }
        return res;
    }




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