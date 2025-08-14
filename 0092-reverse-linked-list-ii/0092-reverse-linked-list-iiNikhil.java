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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lefttail = dummy;
        ListNode curr = head;
        for(int i = 1; i < left; i++){
            lefttail = lefttail.next;
            curr = curr.next;
        }
        ListNode subListHead = curr;
        ListNode pre = null;
        for(int i = left; i <= right; i++){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        lefttail.next = pre;
        subListHead.next = curr;
        return dummy.next;
    }
}