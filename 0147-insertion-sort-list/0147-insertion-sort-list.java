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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next ==null)return head;
        ListNode temp = head.next;

        ListNode tail = head;

        while(temp!=null){
            if(temp.val>=tail.val){
                tail = temp;
                temp = temp.next;
                continue;
            } 
            tail.next = temp.next;

            ListNode prev = null;
            ListNode node = head;
            while(node!=tail.next){
                if(temp.val<=node.val){
                   break;
                }
                prev = node;
                node = node.next;
            }
            if(prev==null){//insertion at head
                temp.next = head;
                head = temp;           
            } else {
                temp.next = prev.next;
                prev.next = temp;
            }
            temp = tail.next;
        }
        return head;
    }
}