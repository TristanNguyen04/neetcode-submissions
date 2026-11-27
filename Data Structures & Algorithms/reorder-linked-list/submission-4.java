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
    /**
    2 -> 4 -> 6 -> 8 -> null

    2 -> 4 -> null
    8 -> 6 -> null
    */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode first = head;
        ListNode second = null;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        second = reverse(slow.next);
        slow.next = null;

        while(second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
