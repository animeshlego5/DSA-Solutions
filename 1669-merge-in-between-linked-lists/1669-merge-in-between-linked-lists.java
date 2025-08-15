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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode curr = dummy.next;
        ListNode tail1 = null;
        ListNode tail = null;
        int i = 0;
        while(curr!=null){
            if(i==a-1){
                tail1 = curr;
            }
            if(i==b+1){
                tail = curr;
            }
            curr = curr.next;
            i++;
        }
        tail1.next = list2;
        while(list2!=null){
            curr = list2;
            list2 = list2.next;
        }
        curr.next = tail;
        return dummy.next;
    }
}