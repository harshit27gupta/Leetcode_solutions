class Solution {

    // Helper function to reverse a linked list
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // Store next node
            curr.next = prev;          // Reverse current pointer
            prev = curr;               // Move prev forward
            curr = next;               // Move curr forward
        }

        return prev; // New head after reversal
    }

    // Main function to check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        // Step 1: Use two-pointer technique to find the middle
        ListNode slow = head;
        ListNode fast = head.next; // Start fast ahead for proper mid in even-length lists

        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow by 1
            fast = fast.next.next;      // Move fast by 2
        }

        // Step 2: Reverse the second half of the list
        ListNode rev = reverse(slow.next);
        slow.next = null; // Optional: Break the list into two halves

        // Step 3: Compare the two halves
        while (rev != null) {
            if (head.val != rev.val) {
                return false; // Mismatch found, not a palindrome
            }
            head = head.next;
            rev = rev.next;
        }

        return true; // All matched, it's a palindrome
    }
}
