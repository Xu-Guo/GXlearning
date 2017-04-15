/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

//be careful about the q.peek().end <= i.start
public class 253_MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        
        Queue<Interval> q = new PriorityQueue<>((x, y) -> x.end - y.end);
        for(Interval i : intervals){
            if(!q.isEmpty() && (q.peek().end <= i.start)){
                q.poll();
            }
            q.offer(i);
        }
        
        return q.size();
        
    }
}