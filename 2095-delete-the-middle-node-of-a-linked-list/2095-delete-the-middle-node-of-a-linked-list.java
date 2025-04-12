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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        if(head.next==null){
            return null;
        }
        while(fast!=null && fast.next!=null){
            if(slow==head && count==0){
                count++;
                fast = fast.next.next;
                continue;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow.next!=null){
        slow.next = slow.next.next;}else {slow.next = null;}
        return head;
    }
}