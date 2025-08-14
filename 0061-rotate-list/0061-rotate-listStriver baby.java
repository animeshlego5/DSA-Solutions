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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        // ListNode slow = head;
        // ListNode fast = head;
        if(head.next == null)return head;
        ListNode end = head;
        int len = 1;
        ListNode length = head;
        while(length!=null && length.next!=null){
            len++;
            length = length.next;
        }
        length.next = head;
        int num = k % len;
        int temp = len - num;
        ListNode tem = head;
        while(temp>0){
            tem =head;
            head = head.next;
            temp--;
        }
        tem.next = null;
        return head;
        
        
    }
}