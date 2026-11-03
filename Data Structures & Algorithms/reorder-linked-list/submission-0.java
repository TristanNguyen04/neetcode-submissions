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

 /*
    2,4,6,8
    --> 2,4,5 and 8,6 --> 2,8,4,6,5
    --> nexts: 4, 6
    --> 
 
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = null;
        slow.next = null;

        // Reverse the second list
        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        ListNode firstList = head;
        ListNode secondList = prev;

        // Merge the two lists
        while(secondList != null){
            ListNode firstNext = firstList.next;
            ListNode secondNext = secondList.next;
            firstList.next = secondList;
            secondList.next = firstNext;
            
            firstList = firstNext;
            secondList = secondNext;
        }
    }
}
