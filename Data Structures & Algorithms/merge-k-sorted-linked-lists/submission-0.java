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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        ListNode newHead = res;

        while (true) {
            int min = Integer.MAX_VALUE;
            ListNode minNode = null;
            int idx = -1;
            boolean allNull = true;
            for (int i = 0; i < lists.length; i++) {
                ListNode temp = lists[i];
                if (temp != null) {
                    if (temp.val < min) {
                        min = temp.val;
                        minNode = temp;
                        idx = i;
                    }
                    allNull = false;
                }
            }
            if (allNull == true) {
                break;
            }
            res.next = minNode;
            lists[idx] = minNode.next;
            res = res.next;
            res.next = null;

        }

        return newHead.next;
    }
}
