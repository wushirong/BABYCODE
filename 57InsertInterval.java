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
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            if (intervals == null || intervals.size() == 0) {
                intervals = new ArrayList<Interval>();
                intervals.add(0, newInterval);
                return intervals;
            }
            intervals.sort(new Comparator<Interval>(){
                public int compare(Interval a, Interval b ) {
                    return a.start < b.start? -1:1;
                }
            });
            int index = 0;
            int len = intervals.size();
            if (newInterval.end < intervals.get(0).start) {
                intervals.add(0,  newInterval);
                return intervals;
            }
            else if (newInterval.start > intervals.get(len-1).end) {
                intervals.add(len, newInterval);
                return intervals;
            }
            
            while (index < intervals.size() && intervals.get(index).end < newInterval.start) index++;
            intervals.add(index, newInterval);
            while(index+1 < intervals.size() && overlap(newInterval, intervals.get(index+1))) {
                Interval cur = merge(intervals.get(index), intervals.get(index+1));
                intervals.set(index, cur);
                intervals.remove(index+1);
            }  
            return intervals;
        }
        
        public static boolean overlap(Interval a, Interval b) {
            if ((a.start >= b.start && a.start <= b.end) || (a.end >= b.start && a.end <= b.end)
                || (a.start >= b.start && a.end <= b.end) || (a.start <= b.end && a.end >= b.start) ) return true;
            return false;
        }
        
        public static Interval merge(Interval a, Interval b) {
            int start = Math.min(a.start, b.start);
            int end = Math.max(a.end, b.end);
            return new Interval(start, end);
        }
}