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
    private ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        ListNode current = head;
        int selectedValue = 0;
        int count = 1;
        while(current!=null){
            if(Math.random()<(1.0 / count)){
                selectedValue = current.val;
            }
            current = current.next;
            count++;
        }
        return selectedValue;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */