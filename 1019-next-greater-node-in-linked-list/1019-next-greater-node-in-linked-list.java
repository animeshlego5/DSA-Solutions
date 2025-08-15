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
    public int[] nextLargerNodes(ListNode head) {
        ListNode node = head;
        List<Integer> values = new ArrayList<>();
        while(node!=null){
            values.add(node.val);
            node = node.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[]res = new int[values.size()];
        for(int i = 0; i < values.size(); i++){
            while(!stack.isEmpty() && (values.get(i) > values.get(stack.peek()))){
                int idx = stack.pop();
                res[idx] = values.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}