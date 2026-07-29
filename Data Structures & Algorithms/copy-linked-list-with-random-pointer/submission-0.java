/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node res = new Node(-1);
        Node newHead = res;
        Node temp = head;

        int idx = 0;
        HashMap<Node, Node> map = new HashMap<>();
        while (temp != null) {
            Node newNode = new Node(temp.val);
            res.next = newNode;
            res = res.next;
            map.put(temp, newNode);
            idx++;
            temp = temp.next;
        }

        temp = head;
        res = newHead.next;
        while (temp != null) {
            Node point = temp.random;
            res.random = map.getOrDefault(point, null);
            temp = temp.next;
            res = res.next;
        }

        return newHead.next;
    }
}