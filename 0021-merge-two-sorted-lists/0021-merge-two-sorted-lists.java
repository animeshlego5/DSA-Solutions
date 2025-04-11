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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        } else if(list2==null){
            return list1;
        }
        ListNode head = null, ptr = null;
        while(list1!=null && list2!=null){
            if(head==null){
                if(list1.val>list2.val){
                    ptr = head = list2;
                    list2 = list2.next;
                } else {
                    ptr = head = list1;
                    list1 = list1.next;
                }
                continue;
            }
            if(list1.val<list2.val){
                ptr.next = list1;
                ptr = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                ptr = list2;
                list2 = list2.next;
            }
            if(list1==null){
                ptr.next = list2;
            } else if(list2==null){
                ptr.next = list1;
            }
        }
        return head;
    }
}