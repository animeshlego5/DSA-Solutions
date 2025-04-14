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
    // public ListNode middle(ListNode head){
    //     ListNode slow = head, fast = head, prev = null;
    //     while(fast!=null && fast.next!=null){
    //         prev = slow;
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return prev;
    // }
    public ListNode mergeSort(ListNode head1,ListNode head2){
        
        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if(head1!=null)tail.next = head1;
        if(head2!=null)tail.next = head2;
        return temp.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];

        int s = lists.length;
        int count = 0;
        ListNode res = null;
        while(s>0){
            res = mergeSort(res, lists[count]);
            count++;
            s--;
        }

        return res;
    }
}