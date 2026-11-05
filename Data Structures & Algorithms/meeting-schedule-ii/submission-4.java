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
        
            40


    */
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        intervals.sort((a,b) -> a.start - b.start);

        for(Interval interval : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start){
                minHeap.poll();
            }

            minHeap.offer(interval.end);
        }
        
        return minHeap.size();
    }
}
