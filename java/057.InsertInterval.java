// Question 57 Insert Interval

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) { 
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
                                       Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}