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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerDummy = new ListNode(-1);
        ListNode biggerDummy = new ListNode(-1);
        ListNode smallerCurr = smallerDummy;
        ListNode biggerCurr = biggerDummy;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val<x){
                smallerCurr.next = curr;
                smallerCurr = smallerCurr.next;
            } else {
                biggerCurr.next = curr;
                biggerCurr = biggerCurr.next;
            }
            curr = curr.next;
        }
        biggerCurr.next = null;
        smallerCurr.next = biggerDummy.next;
        return smallerDummy.next;
    }
}