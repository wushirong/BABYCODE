    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int max = 0;
        for (Interval i: intervals) {
            max = Math.max(max, i.end);
        }
        int[] record = new int[max+1];
        
        for(int i = 0; i < intervals.length; i++) {
            Interval cur = intervals[i];
            record[cur.start]++;
            record[cur.end]--;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < record.length; i++) {
            count += record[i];
            record[i] = count;
            res = Math.max(res, count);
        }
        return res;
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            Interval cur = pq.poll();
            if(intervals[i].start < cur.end) pq.offer(intervals[i]);
            else {
                cur.end = intervals[i].end;
            }
            pq.offer(cur);
        }
        return pq.size();
    }
}