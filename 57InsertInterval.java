/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int index = 0;
        if(intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        while(index < intervals.size() && intervals.get(index).end < newInterval.start) {
            res.add(intervals.get(index++));
        }
        
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(index).start, newInterval.start), 
                                       Math.max(intervals.get(index).end, newInterval.end));
            index++;
        }
        res.add(newInterval);
        while(index < intervals.size()) res.add(intervals.get(index++));
        return res;
    }
}