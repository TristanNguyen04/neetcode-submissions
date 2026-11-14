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

// public class ListNode {
//     int val;  
//     ListNode next;

//     ListNode(){}
//     ListNode(int val){
//         this.val = val;
//     }
//     ListNode(int val, ListNode next){
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    /*
        1 -> 2 -> 3 -> 4
        n = 2

        4 -> 3 -> 2 -> 1 -> null | n = 2;

        4 -> 
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reversed = reverse(head);
        if(n == 1){
            return reverse(reversed.next);
        }

        ListNode current = reversed;

        for(int i = 0; i < n - 2; i++){
            current = current.next;
        }

        current.next = current.next.next;

        return reverse(reversed);
    }

    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode previous = null;

        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}





