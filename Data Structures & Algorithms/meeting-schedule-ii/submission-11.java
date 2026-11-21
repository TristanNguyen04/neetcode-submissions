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

// public class Interval{
//     int start;
//     int end;

//     public Interval(int start, int end){
//         this.start = start;
//         this.end = end;
//     }
// }

/**
    (0,40), (5,10), (15,20)
*/

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        intervals.sort((a, b) -> a.start - b.start);

        for(Interval interval : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start){
                minHeap.poll();
            }

            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}
