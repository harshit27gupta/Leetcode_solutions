class Solution {
    public ListNode reverseList(ListNode head) {
        // Initialize the previous node as null (will be the new tail)
        ListNode prev = null;

        // Start traversal from the head of the list
        ListNode curr = head;

        // Iterate through the list until all nodes are reversed
        while (curr != null) {
            // Temporarily store the next node before breaking the link
            ListNode nextTemp = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev to current (step forward in the reversed list)
            prev = curr;

            // Move curr to the next original node
            curr = nextTemp;
        }

        // At the end, prev will point to the new head of the reversed list
        return prev;
    }
}
