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
    public boolean hasCycle(ListNode head) {
        ListNode curr1 = head;
        ListNode curr2 = head;

        while(curr1 != null && curr2 != null){
            curr1 = curr1.next;

            if(curr2.next != null){
                curr2 = curr2.next.next;
            }

            if(curr1 == curr2) return true;
        }

        return false;
    }
}
