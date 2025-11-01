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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        ListNode dummyhead = new ListNode(0);
        ListNode current = dummyhead;

        while(head!=null){
            if(set.contains(head.val)){
                head = head.next;
            }else{
                current.next = head;
                current = current.next;
                head = head.next;
            }
        }
        current.next = null;
        return dummyhead.next;
    }
}