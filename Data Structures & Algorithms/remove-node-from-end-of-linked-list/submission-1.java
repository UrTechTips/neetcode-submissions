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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (n == size) return head.next;

        int i = size - n;
        ListNode curr = head;
        for (int j = 0; j < i - 1; j++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }
}
