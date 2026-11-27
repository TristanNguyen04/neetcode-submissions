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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reversed = reverse(head);
        ListNode current = reversed;

        if(n == 1){
            return reverse(reversed.next);
        }

        for(int i = 0; i < n - 2; i++){
            current = current.next;
        }

        current.next = current.next.next;

        return reverse(reversed);
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
