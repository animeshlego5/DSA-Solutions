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
    public int length(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevHead = null;
        ListNode currHead = head;
        ListNode ansHead = null;
        int l = length(head);
        for(int i = 0; i < (l/k); i++) {
            ListNode curr = currHead;
            ListNode newhead = null;
            ListNode prev = null;
            for(int j = 0 ; j <k;j++){
                newhead = curr.next;
                curr.next = prev;
                prev = curr;
                curr = newhead;
            }
            if(prevHead==null){
                ansHead = prev;
            } else {
                prevHead.next = prev;
            }
        prevHead = currHead;
        currHead = curr;
        }
        prevHead.next = currHead;
        return ansHead;
    }
}