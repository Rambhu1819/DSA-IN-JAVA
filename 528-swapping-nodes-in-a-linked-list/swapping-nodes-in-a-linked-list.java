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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;

        for(int i = 1; i < k ; i++) {first = first.next;}

        ListNode fontK = first;

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0 ; i < k; i++){ fast = fast.next; }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode lastK = slow;
        
        int temp = fontK.val;
        fontK.val = lastK.val;
        lastK.val = temp;

       return head;

    }
}