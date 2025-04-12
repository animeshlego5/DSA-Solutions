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
    public ListNode swapPairs(ListNode head) {
        ListNode slow = head;
        ListNode prev = null;

        while(slow!=null && slow.next!=null){
            ListNode fast = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            
            if(prev==null){
                head = fast;
            } else {
                prev.next = fast;
            }
            prev = slow;
            slow = slow.next;
        }
        return head;
    }
}