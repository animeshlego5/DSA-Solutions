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
    public ListNode middle(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;

        ListNode mid = middle(head),left = head, right = mid.next; 
        mid.next = null;
        ListNode l1 = sortList(left), l2 = sortList(right);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1!=null &&l2!= null){
            if(l1.val<l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
    }
    if(l2!=null)tail.next = l2;
    if(l1!=null)tail.next = l1;
    return dummy.next;
}
}