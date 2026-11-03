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
    1,2,3,4
    --> reverse(list) 
    --> 4,3,2,1
    --> remove(list, n) --> 4,2,1 (change the pointer -- O(1))
    --> reverse(list)
    --> 1,2,4

    Time: O(2*n) = O(n); 
    Space: O(1)
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // First Reverse
        ListNode reversed = reverse(head);

        ListNode dummy = new ListNode(0, reversed);
        ListNode curr = dummy;

        for(int i = 0; i < n - 1; i++){
            curr = curr.next;
        }

        curr.next = curr.next != null ? curr.next.next : null;

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
