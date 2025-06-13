class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode current = head;

        while (current != null) {
            int count = 0;
            ListNode temp = current;
            while (count < k && temp != null) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }
            if (count == k) {
                while (!stack.isEmpty()) {
                    tail.next = stack.pop();
                    tail = tail.next;
                }
                current = temp;
            } else {
                while (!stack.isEmpty()) {
                    tail.next = stack.remove(0);  
                    tail = tail.next;
                }
                break;
            }
        }

        tail.next = null;
        return dummy.next;
    }
}
