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
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head, ptr;

        // Initialize head and ptr
        if (list1.val < list2.val) {
            head = ptr = list1;
            list1 = list1.next;
        } else {
            head = ptr = list2;
            list2 = list2.next;
        }

        // Main merge loop
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        // Attach the remaining part of the non-empty list
        ptr.next = (list1 != null) ? list1 : list2;

        return head;
    }
}
