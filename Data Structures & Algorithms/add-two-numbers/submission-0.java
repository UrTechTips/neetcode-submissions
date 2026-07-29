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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cary = 0;
        ListNode res = new ListNode();
        ListNode newHead = res;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + cary;
            cary = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            res.next = newNode;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + cary;
            cary = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            res.next = newNode;
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + cary;
            cary = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            res.next = newNode;
            res = res.next;
            l2 = l2.next;
        }

        if (cary != 0) {
            ListNode newNode = new ListNode(cary);
            res.next = newNode;
            res = res.next;
        }

        return newHead.next;
    }
}
