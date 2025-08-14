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
    public ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode (-1);
        ListNode temp = dummy;

        ListNode p1 = reverseLL(l1);
        ListNode p2 = reverseLL(l2);

        int carry = 0;

        while(p1 != null || p2 != null || carry != 0){
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;

            int sum = x + y + carry;
            carry = sum/10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if(p1 != null) p1 = p1.next ; 
            if(p2 != null) p2 = p2.next ;
        }
        return reverseLL(dummy.next);
    }
}