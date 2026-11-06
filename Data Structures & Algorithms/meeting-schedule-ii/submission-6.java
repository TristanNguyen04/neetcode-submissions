/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    /**
        [(0,40),(5,10),(15,20)]

            10
        40      
    */
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start){
                minHeap.poll();
            }
            
            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}
