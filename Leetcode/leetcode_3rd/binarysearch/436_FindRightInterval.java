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
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0){
            return new int[1];
        }
        if (intervals.length == 1){
            return new int[]{-1};
        }
        Map<Interval, Integer> map = new HashMap<>();
        for (int i= 0; i < intervals.length; i++){
            map.put(intervals[i], i);
        }
        
        Interval[] copy = Arrays.copyOf(intervals, intervals.length);
        
        Arrays.sort(copy, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++){
            if (searchInterval(copy, intervals[i].end) != -1){
                res[i] = map.get(copy[searchInterval(copy, intervals[i].end)]);
            } else {
                res[i] = -1;
            }
            
        }
        return res;
        
    }
    
    private int searchInterval(Interval[] intervals, int end){
        int left = 0;
        int right = intervals.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (intervals[mid].start >= end){
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (intervals[left].start >= end){
            return left;
        }
        if (intervals[right].start >= end ){
            return right;
        }
        return -1;
    }
}