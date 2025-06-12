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
    static int count(ListNode t) {
        int cc = 0;
        while (t != null) {
            t = t.next;
            cc++;
        }
        return cc;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = count(head);
        int target = total - n;

        // Edge case: remove the head
        if (target == 0) return head.next;

        ListNode curr = head;
        for (int i = 1; i < target; i++) {
            curr = curr.next;
        }

        // Remove the nth node from end
        curr.next = curr.next.next;

        return head;
    }
}
