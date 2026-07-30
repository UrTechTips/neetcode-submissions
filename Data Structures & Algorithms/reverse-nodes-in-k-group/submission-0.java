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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        ListNode newHead = res;
        while (head != null) {
            Stack<ListNode> st = new Stack<>();
            st.push(null);

            boolean smallGroup = false;
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    smallGroup = true;
                    break;
                }
                st.push(head);
                head = head.next;
            }

            ListNode groupHead = null;
            if (smallGroup == true) {
                while (st.peek() != null) {
                    System.out.println("Small");
                    groupHead = st.pop();
                }
            } else {
                while (!st.isEmpty()) {
                    ListNode temp = st.pop();
                    if (temp != null) {
                        temp.next = st.peek();
                    }
                    if (groupHead == null) {
                        groupHead = temp;
                    }
                }
            }
            res.next = groupHead;
            while (res.next != null) {
                res = res.next;
            }
        }
    
        return newHead.next;
    }
}
