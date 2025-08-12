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
    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        int count = -1;
        while(node!=null){
            count++;
            node = node.next;
        }
        node = head;
        int number = 0;
        while(node!=null){
            number += Math.pow(2, count) * node.val;
            node = node.next;
            count--;
        }
        return number;
    }
}