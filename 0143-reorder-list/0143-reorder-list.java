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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;

        //reverse this list
        ListNode prev = null;
        while(secondHead!=null){
            ListNode next = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = next;
        }
        //prev is new head
        ListNode t1 = head;
        ListNode t2 = prev;

        while(t2!=null){
            ListNode m1 = t1.next;
            ListNode m2 = t2.next;
            t1.next = t2;
            t2.next = m1;
            t1 = m1;
            t2 = m2;
        }
    }
}