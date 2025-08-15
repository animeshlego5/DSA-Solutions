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
        ListNode slow = head;
        ListNode fast = head;
        
        int temp = 0;
        ListNode kthFromStart = null;
        while(k>1){
            fast = fast.next;
            k--;
        }
        kthFromStart = fast;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        temp = kthFromStart.val;
        kthFromStart.val = slow.val;
        slow.val = temp;
        return head;
    }
}