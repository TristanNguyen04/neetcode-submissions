/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for(ListNode list : lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            current.next = smallest;

            if(smallest.next != null){
                minHeap.offer(smallest.next);
            }

            current = current.next;
        }
        
        return dummy.next;
    }
}
